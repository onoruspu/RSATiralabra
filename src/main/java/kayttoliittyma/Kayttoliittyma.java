
package kayttoliittyma;

import apu.MerkkijonoMuutos;
import java.math.BigInteger;
import java.util.Scanner;
import avain.SalausPurku;
import avain.Avain;
import avain.AvaimenLuoja;

/**
 * Käyttöliittymä. Käyttäjän on mahdollista käyttöliittymän kautta käyttää sovelluksen toimnnallisuuksia.
 */
public class Kayttoliittyma {
    /**
     * Montako päätason komentoa käyttöliittymä tunnistaa.
     */
    private static final int PÄÄTASON_KOMENTOJEN_LUKUMÄÄRÄ = 6;

    /**
     * Kuinka pitkiä päätason komennot ovat.
     */
    private static final int PÄÄTASON_KOMENNON_PITUUS = 1;

    /**
     * Syötteen lukija.
     */
    private final Scanner syötteenLukija;

    /**
     * Muuttujalla pidetään kirjaa siitä jatketaanko ohjelman suoritusta päätasolla.
     * Asetetaan muuttuja aluksi epätodeksi, jotta suoritus ei koskaan ala tarkoituksettomasti.
     */
    private boolean jatkaPäätasonSilmukkaa = false;

    /**
     * Muuttujalla pidetään kirjaa siitä jatketaanko ohjelman suoritusta alemmalla tasolla.
     */
    private boolean jatkaAlitasonSilmukkaa = false;

    /**
     * Parametriton konstruktori käyttöliittymälle.
     */
    public Kayttoliittyma() {
        this.syötteenLukija = new Scanner(System.in);
    }

    /**
     * Parematerillinen konstruktori käyttöliittymälle.
     *
     * @param newScanner Lukija käyttäjän syötteille.
     */
    public Kayttoliittyma(final Scanner newScanner) {
        this.syötteenLukija = newScanner;
    }

    /**
     * Käynnistä käyttöliittymä.
     */
    public void käynnistä() {
        System.out.println("\nTervetuloa RSA salausohjelmaan."); // Tervetuloviesti.
        this.jatkaPäätasonSilmukkaa = true; // Asetetaan silmukka käyttöön.
        pääSilmukka(); // Suoritetaan sovellusta, kunnes käyttäjä sulkee sen.
    }

    /**
     * Käyttöliittymän päätason silmukka. Niin kauan kuin päätason silmukka on suorituksessa, on ohjelmakin päällä.
     */
    public void pääSilmukka() {
        while (this.jatkaPäätasonSilmukkaa) { // Päätason silmukka.
            tulostaPääkomennot(); // Kerrotaan päätason komennot.
            String input = lueSyöte("\nKomento: "); // Luetaan syöte.
            if (onPääkomento(input)) {
                int subLevel = komennonArvo(input);
                if (subLevel == 0 || subLevel == 1) {
                    suoritaKomento(subLevel); // Komennot 0,1, joilla ei ole mielekästä
                                          // alemman tason silmukkaa suoritetaan suoraan.
                } else {
                    aliSilmukka(subLevel); // Komennot 2,3,4,5. Siirrytään alemman tason silmukkaan.
                }
            } else {
                eiPääkomento(); // Virheellinen komento.
            }
        }
    }

    /**
     * Käyttöliittymän alitason silmukka. Päätason silmukka voi kutsua alemman tason silmukoita,
     * mikäli näille on tarvetta.
     *
     * @param subLevel arvo, joka määrittää mitä komentoa alitason silmukka suorittaa.
     */
    public void aliSilmukka(final int subLevel) {
        this.jatkaAlitasonSilmukkaa = true; // Asetetaan alempi silmukka pyörimään.
        while (this.jatkaAlitasonSilmukkaa) { // Jatketaan suoritusta kunnes käyttäjä poistuu silmukasta.
            tulostaAlikomennot(subLevel); // Kerrotaan tietoa käyttäjälle.
            suoritaKomento(subLevel); // Suoritetaan itse komento.
        }
    }

    /**
     * Luetaan käyttäjältä syöte.
     *
     * @param messageToUser käyttäjälle lähetettävä viesti, jolla voidaan esimerkiksi tarkentaa haluttua syötettä.
     * Mikäli viesti ei ole tarpeellinen voidaan lähettää tyhjä merkkijono "".
     *
     * @return käyttäjän antama syöte.
     */
    public String lueSyöte(final String messageToUser) {
        System.out.print(messageToUser);
        String input = this.syötteenLukija.nextLine();
        return input;
    }


    /**
     * Tarkistetaan onko annettu syöte päätason komento.
     *
     * @param input käyttäjän syöte.
     *
     * @return onko syöte sallittu?
     */
    public boolean onPääkomento(final String input) {
        if (!onEpänegatiivinenLuku(input)) {
            return false;
        }
        if (input.length() != Kayttoliittyma.PÄÄTASON_KOMENNON_PITUUS) { // Tarkista komennon pituus.
            return false;
        }
        int command = Integer.valueOf(input); // Syöte luvuksi.
        // Tarkista, että että komento on sallitulla välillä [0, thisPÄÄTASON_KOMENTOJEN_LUKUMÄÄRÄ-1].
        if (command < 0 || command > Kayttoliittyma.PÄÄTASON_KOMENTOJEN_LUKUMÄÄRÄ - 1) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistetaan onko annettu syöte epänegatiivinen numero.
     *
     * @param input käyttäjän syöte.
     *
     * @return onko syöte epänegatiivinen numero?
     */
    public boolean onEpänegatiivinenLuku(final String input) {
        if (input == null) { // Tarkista, että viittaus on aito.
            return false;
        }
        if (input.length() <= 0) { // Tarkista pituus.
            return false;
        }
        if (!sisältääVainNumeroita(input)) { // Tarkista, että syöte koostuu numeroista.
            return false;
        }
        return true;
    }

    /**
     * Tarkistetaan onko annettu syöte positiivinen numero.
     *
     * @param input käyttäjän syöte.
     *
     * @return onko syöte positiivinen numero?
     */
    public boolean onPositiivinenLuku(final String input) {
        if (onEpänegatiivinenLuku(input) && !input.equals("0")) {
            // Jos syöte ei ole epänegatiivinen numero eikä nolla, on se positiivinen.
            return true;
        }
        return false;
    }

    /**
     * Tarkistetaan, että syöte sisältää vain numeroita.
     *
     * @param input käyttäjän syöte.
     *
     * @return onko syötteessä vain numeroita?
     */
    public boolean sisältääVainNumeroita(final String input) {
        for (int i = 0; i < input.length(); i++) { // Tarkista, että syötteessä on vain numeroita.
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Ilmoita käyttäjälle virheellisestä syötteestä ja kerro päätasoon komennot.
     */
    public void eiPääkomento() {
        System.out.println("\nVirheellinen komento.");
        tulostaPääkomennot();
    }

    /**
     * Kerätään syötteestä tieto siitä mitä komentoa halutaan suorittaa.
     *
     * @param input komento tekstimuodossa.
     *
     * @return komennon numero kokonaislukuna.
     */
    public int komennonArvo(final String input) {
        // Syötteen tarkistuksen tulisi estää, että muunnos kokonaisluvuksi ei epäonnistu koskaan.
        return Integer.valueOf(input);
    }

    /**
     * Suorita komento.
     *
     * @param command komennon numero kokonaislukuna.
     */
    public void suoritaKomento(final int command) {
        if (command == 0) {
            sulje();
        } else if (command == 1) {
            luoAvaimet();
        } else if (command == 2) {
            viestiLukujenMuotoon();
        } else if (command == 3) {
            lukuViestinMuotoon();
        } else if (command == 4) {
            salaus();
        } else if (command == 5) {
            purku();
        }
    }

    /**
     * Asetetaan ohjelma suljettavaksi ja kerrotaan tästä käyttäjälle.
     */
    public void sulje() {
        System.out.println("Suljetaan ohjelma.");
        this.jatkaPäätasonSilmukkaa = false;
        this.jatkaAlitasonSilmukkaa = false;
    }

    /**
     * Luodaan julkinen ja yksityinen RSA avain ja kerrotaan nämä käyttäjälle.
     */
    public void luoAvaimet() {
        AvaimenLuoja keyGen = new AvaimenLuoja();
        Avain key = keyGen.luoAvaimet();
        System.out.println("Luodun avaimen arvot:");
        System.out.print("n: ");
        System.out.println(key.getN());
        System.out.print("e: ");
        System.out.println(key.getE());
        System.out.print("d: ");
        System.out.println(key.getD());
    }

    /**
     * Muutetaan viesti numeroiksi ja kerrotaan tulos käyttäjälle.
     */
    public void viestiLukujenMuotoon() {
        String input = lueSyöte("Luvuksi muutettava viesti: ");
        if (tarkistaPaluu(input)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }
        MerkkijonoMuutos stringConvert = new MerkkijonoMuutos();
        String numberForm = stringConvert.merkkijonoLukujenMuotoon(input);
        System.out.println("Viesti lukuna:\n" + numberForm);
        System.out.println("Riippuen (konsolin) konfiguraatioista ei kaikkia merkkejä välttämättä saada muutettua."
                + " Tarkista, että alla oleva tulostus on järkevä. Mikäli ei ole, muuta käyttämiäsi merkkejä.");
        System.out.println("Tarkistus:\n" + stringConvert.lukujenMuotoMerkkijonoksi(numberForm));
        this.jatkaAlitasonSilmukkaa = false; // Palataan pääsilmukkaan.
    }

    /**
     * Muutetaan merkkijonona olevat numerot merkeiksi ja kerrotaan tulos käyttäjälle.
     */
    public void lukuViestinMuotoon() {
        String input = lueSyöte("Viestiksi muutettava luku: ");
        if (tarkistaPaluu(input)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }
        if (onPositiivinenLuku(input)) {
            MerkkijonoMuutos stringConvert = new MerkkijonoMuutos();
            String messageForm = stringConvert.lukujenMuotoMerkkijonoksi(input);
            System.out.println("Luku viestinä:\n" + messageForm);
            this.jatkaAlitasonSilmukkaa = false; // Palataan pääsilmukkaan.
        } else {
            System.out.println("Virheellinen syöte. Onhan syöte positiivinen luku?");
        }

    }

    /**
     * Viestin salaus. Kerrotaan tulos käyttäjälle.
     */
    public void salaus() {
        // Haluamme sallia käyttäjälle poistumisen kaikissa kohdissa.
        // Tämän takia jokaisen syötteen jälkeen on tarkistus.
        String inputNumber = lueSyöte("Anna viesti (numeroina): ");
        if (tarkistaPaluu(inputNumber)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        String inputE = lueSyöte("Anna julkinen avain (e): ");
        if (tarkistaPaluu(inputE)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        String inputN = lueSyöte("Anna osamäärä (n): ");
        if (tarkistaPaluu(inputN)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        // Tarkistetaan syöte
        if (onPositiivinenLuku(inputNumber) && onPositiivinenLuku(inputN) && onPositiivinenLuku(inputE)) {
            SalausPurku deencode = new SalausPurku(); // Uusi salausolio.
            Avain key = new Avain(new BigInteger(inputN), new BigInteger(inputE), new BigInteger("0")); // Uusi avain.
            String encoded = deencode.salaus(key, new BigInteger(inputNumber)); // Varsinainen salaus.
            System.out.println("Viesti salatussa muodossa:\n" + encoded); // Kerrotaan käyttäjälle.
            this.jatkaAlitasonSilmukkaa = false; // Poistutaan alemman tason silmukasta.
        } else {
            System.out.println("Virheellinen syöte. Onhan syöte positiivinen luku?");
        }
    }

    /**
     * Viestin purku. Kerrotaan tulos käyttäjälle.
     */
    public void purku() {
        // Haluamme sallia käyttäjälle poistumisen kaikissa kohdissa.
        // Tämän takia jokaisen syötteen jälkeen on tarkistus.
        String inputNumber = lueSyöte("Anna viesti (numeroina): ");
        if (tarkistaPaluu(inputNumber)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        String inputN = lueSyöte("Anna osamäärä (n): ");
        if (tarkistaPaluu(inputN)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        String inputD = lueSyöte("Anna yksityinen avain (d): ");
        if (tarkistaPaluu(inputD)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        // Tarkistetaan syöte
        if (onPositiivinenLuku(inputNumber) && onPositiivinenLuku(inputN) && onPositiivinenLuku(inputD)) {
            SalausPurku deencode = new SalausPurku(); // Uusi purkuolio.
            Avain key = new Avain(new BigInteger(inputN), new BigInteger("0"), new BigInteger(inputD)); // Uusi avain.
            String decoded = deencode.purku(key, new BigInteger(inputNumber)); // Varsinainen purku.
            System.out.println("Viesti puretussa muodossa:\n" + decoded); // Kerrotaan käyttäjälle.
            this.jatkaAlitasonSilmukkaa = false; // Poistutaan alemman tason silmukasta.
        } else {
            System.out.println("Virheellinen syöte. Onhan syöte positiivinen luku?");
        }
    }

    /**
     * Tarkistetaan haluaako käyttäjä palata takaisin päätasolle.
     *
     * @param input käyttäjän syöte.
     *
     * @return palataanko takaisin päätasolle?
     */
    public boolean tarkistaPaluu(final String input) {
        if (input.equals("0")) {
            System.out.println("Palataan takaisin.");
            this.jatkaAlitasonSilmukkaa = false;
            return true;
        }
        return false;
    }

    /**
     * Tulostetaan sallitut päätason komennot.
     */
    public void tulostaPääkomennot() {
        System.out.println("\nKomennot:");
        System.out.println("0 - Sulje ohjelma.");
        System.out.println("1 - Luo julkinen ja yksityinen RSA-avain.");
        System.out.println("2 - Muuta viesti luvuksi.");
        System.out.println("3 - Muuta luku viestiksi.");
        System.out.println("4 - Salaa viesti.");
        System.out.println("5 - Pura viesti.");
    }

    /**
     * Tulostetaan alitason komentoon liittyvät tiedot.
     *
     * @param subLevel suoritettavan alitason komento kokonaislukuna.
     */
    public void tulostaAlikomennot(final int subLevel) {
        // Kaikille alikomennoille yhteiset tulosteet.
        System.out.println("\nKomennot:");
        System.out.println("0 - Palaa takaisin.");
        // Komennnoilla 0 ja 1 ei ole ylimääräisiä alisilmukan tuloksia, sillä näihin ei voida jäädä pyörimään.
        if (subLevel == 2) {
            System.out.println("Muutetaan viesti luvuksi. Muutos suoritetaan muuttamalla merkit Unicode arvoiksi."
                    + " Mikäli haluat käyttää jotain muuta muutostapaa, tee se toisessa sovelluksessa ja käytä tätä"
                    + " sovellusta vain purkuun ja salaukseen.");
        } else if (subLevel == 3) {
            System.out.println("Muutetaan luku viestiksi. Muutos toteutetaan tulkitsemalla luvut Unicode arvoina. "
                    + " Varmista, että alkuperäinen muutos on toteutettu Unicode arvoilla,"
                    + " muuten tämä muutos ei ole mielekäs.");
        } else if (subLevel == 4) {
            System.out.println("Salataan viesti. Salaukseen tarvitaan julkinen avain ja osamäärä."
                    + " Huomioi, että viestin oltava lukuna.");
        } else if (subLevel == 5) {
            System.out.println("Puretaan viesti. Purkamiseen tarvitaan yksityinen avain ja osamäärä."
                    + " Huomioi, että viestin on oltava lukuna.");
        }
    }
}
