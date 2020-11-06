
// Tulostusten testaustapa StackOverFlow:sta käyttäjältä dfa (https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println)
// Vastaavaa metodia on käytetty myös esimerkkityössä (https://github.com/TiraLabra/Testing-and-rmq).

package ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UITest {
    private final UI UI = new UI(new Scanner("0"));
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    @Test
    public void testStart() {
        UI UI0 = new UI(new Scanner("0")); // Syötteenä "0"
        UI0.start();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));
        
        UI UIa = new UI(new Scanner("1\n0")); // Syötteenä "a"
        UIa.start();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Komennot:"));
        
        UI UI9 = new UI(new Scanner("9\n0")); // Syötteenä "9"
        UI9.start();
        assertTrue(outContent.toString().contains("Tervetuloa RSA salausohjelmaan."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("Komennot:"));
    }
    
    @Test
    public void testIsMalformedInput() {
        assertTrue(this.UI.isMalformedInput("-0"));
        assertTrue(this.UI.isMalformedInput("-1"));
        assertFalse(this.UI.isMalformedInput("0"));
        assertFalse(this.UI.isMalformedInput("1"));
        assertTrue(this.UI.isMalformedInput("2"));
        assertTrue(this.UI.isMalformedInput("3"));
        assertTrue(this.UI.isMalformedInput("4"));
        assertTrue(this.UI.isMalformedInput(""));
        assertTrue(this.UI.isMalformedInput(null));
        assertTrue(this.UI.isMalformedInput("a"));
        assertTrue(this.UI.isMalformedInput("10"));
        assertTrue(this.UI.isMalformedInput("00"));
        assertTrue(this.UI.isMalformedInput("\n"));
        assertTrue(this.UI.isMalformedInput("\t"));
        assertTrue(this.UI.isMalformedInput("0\n"));
    }
    
    @Test
    public void testGetCommand() {
        assertEquals(-1, this.UI.getCommand("-1"));
        assertEquals(0, this.UI.getCommand("0"));
        assertEquals(1, this.UI.getCommand("1"));
        assertEquals(2, this.UI.getCommand("2"));
        assertEquals(3, this.UI.getCommand("3"));
        assertEquals(4, this.UI.getCommand("4"));
        assertEquals(5, this.UI.getCommand("5"));
        assertEquals(6, this.UI.getCommand("6"));
        assertEquals(7, this.UI.getCommand("7"));
        assertEquals(8, this.UI.getCommand("8"));
        assertEquals(9, this.UI.getCommand("9"));
        assertEquals(10, this.UI.getCommand("10"));
        assertEquals(100, this.UI.getCommand("100"));
        assertEquals(1234, this.UI.getCommand("1234"));
    }
    
    @Test
    public void testRunCommand() {
        this.UI.runCommand(0); // Komento 0
        assertTrue(outContent.toString().contains("Suljetaan ohjelma."));
        
        this.UI.runCommand(1); // Komento 1
        assertTrue(outContent.toString().contains("Luodun avaimen arvot:"));
        assertTrue(outContent.toString().contains("n:"));
        assertTrue(outContent.toString().contains("e:"));
        assertTrue(outContent.toString().contains("d:"));
    }
    
    @Test
    public void testPrintCommands() {
        this.UI.printCommands();
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("0 - Sulje ohjelma."));
    }
    
    @Test
    public void testMalformedInput() {
        this.UI.malformedInput();
        assertTrue(outContent.toString().contains("Virheellinen komento."));
        assertTrue(outContent.toString().contains("Komennot:"));
        assertTrue(outContent.toString().contains("0 - Sulje ohjelma."));
    }
}