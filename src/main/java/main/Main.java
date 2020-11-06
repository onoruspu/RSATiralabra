
// Main luokka, ohjelman suoritus alkaa täältä.

package main;

import java.util.Scanner;

public class Main {
    
    /**
     * Käynnistä ohjelma.
     * 
     * @param args parametreja ei huomioida.
     */
    public static void main(String[] args) {
        
        new ui.UI(new Scanner(System.in)).start(); // Käynnistetään käyttöliittymä.
        
    }
}
