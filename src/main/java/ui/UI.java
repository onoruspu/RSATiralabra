
package ui;

import java.util.Scanner;
import rsa.Key;
import rsa.KeyGenerator;

public class UI {
    // "main" komennot ovat ylimmän tason komentoja, joista haarautuu kaikki muut komennot.
    private final int mainCommandAmount = 2; // Montako päätason komentoa käyttöliittymä tunnistaa.
    private final int mainCommandLength = 1; // Kuinka pitkiä päätason komennot ovat.
    private final Scanner scanner; // Syötteen lukija.
    private boolean continueLoop = true; // Muuttuja pitää kirjaa ohjelman sulkemisesta.
    
    /**
     * Konstruktori käyttöliittymälle.
     * 
     * @param scanner antaa käyttäjän syötteet ohjelmalle.
     */
    public UI(Scanner scanner) {
        this.scanner = scanner;
    }
    
    /**
     * Käynnistä käyttöliittymä.
     */
    public void start() {
        System.out.println("\nTervetuloa RSA salausohjelmaan."); // Tervetuloviesti.
        printCommands(); // Kerrotaan komennot.
        while (continueLoop) { // Jatketaan suoritusta, kunnes käyttäjä sulkee ohjelman.
            System.out.print("\nKomento: ");
            String input = "";
            input = this.scanner.nextLine();
            if (isMalformedInput(input)) {
                malformedInput(); // Virheellinen komento.
            } else {
                runCommand(getCommand(input)); // Sallittu komento.
            }
        } 
    }
    
    /**
     * Tarkistetaan syötteen oikeellisuus.
     * 
     * @param input syöte.
     * 
     * @return boolean onko syöte sallittu.
     */
    public boolean isMalformedInput(String input) {
        if (input == null) { // Tarkista että viittaus on aito.
            return true;
        }
        if (input.length() != this.mainCommandLength) { // Tarkista komennon pituus.
            return true;
        }
        for (int i=0; i<input.length(); i++) { // Tarkista, että komennossa on vain numeroita.
            if (!Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        int command = Integer.valueOf(input);
        if (command < 0 || command > this.mainCommandAmount-1) { // Tarkista, että että komento on sallitulla välillä [0, this.mainCommandAmount-1].
            return true;
        }
        return false;
    }
    
    /**
     * Ilmoita virheellisestä syötteestä ja kerro kommenot.
     */
    public void malformedInput() {
        System.out.println("\nVirheellinen komento.");
        printCommands();
    }
    
    /**
     * Kerätään syötteestä tieto siitä mitä komentoa halutaan suorittaa.
     * 
     * @param input komento tekstimuodossa.
     * 
     * @return komennon numero.
     */
    public int getCommand(String input) {
        return Integer.valueOf(input); // Syötteen tarkistuksen tulisi estää, että koskaan muunnos kokonaisluvuksi ei epäonnistu koskaan.
    }
    
    /**
     * Suorita komento.
     * 
     * @param command komennon numero kokonaislukuna.
     */
    public void runCommand(int command) {
        if (command == 0) {
            exit();
        }
        if (command == 1) {
            generateKeys();
        }
    }
    
    /**
     * Suljetaan ohjelma.
     */
    public void exit() {
        System.out.println("Suljetaan ohjelma.");
        this.continueLoop = false;
    }
    
    /**
     * Luodaan julkinen ja yksityinen RSA avain ja kerrotaan nämä käyttäjälle.
     */
    public void generateKeys() {
        KeyGenerator keyGen = new KeyGenerator();
        Key key = keyGen.createKeys();
        System.out.println("Luodun avaimen arvot:");
        System.out.print("n: ");
        System.out.println(key.getN());
        System.out.print("e: ");
        System.out.println(key.getE());
        System.out.print("d: ");
        System.out.println(key.getD());
    }
    
    /**
     * Tulostetaan sallitut komennot.
     */
    public void printCommands() {
        System.out.println("\nKomennot:");
        System.out.println("0 - Sulje ohjelma.");
        System.out.println("1 - Luo julkinen ja yksityinen RSA avain.");
    }
}
