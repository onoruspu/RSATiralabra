
package kayttoliittyma;

import apu.MerkkijonoMuutos;
import java.util.Scanner;
import avain.SalausPurku;
import avain.Avain;
import avain.AvaimenLuoja;
import tietorakenteet.SuuriLuku;

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
            String syöte = lueSyöte("\nKomento: "); // Luetaan syöte.
            if (onPääkomento(syöte)) {
                int aliTaso = komennonArvo(syöte);
                if (aliTaso == 0 || aliTaso == 1) {
                    suoritaKomento(aliTaso); // Komennot 0,1, joilla ei ole mielekästä
                                          // alemman tason silmukkaa suoritetaan suoraan.
                } else {
                    aliSilmukka(aliTaso); // Komennot 2,3,4,5. Siirrytään alemman tason silmukkaan.
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
     * @param aliTaso arvo, joka määrittää mitä komentoa alitason silmukka suorittaa.
     */
    public void aliSilmukka(final int aliTaso) {
        this.jatkaAlitasonSilmukkaa = true; // Asetetaan alempi silmukka pyörimään.
        while (this.jatkaAlitasonSilmukkaa) { // Jatketaan suoritusta kunnes käyttäjä poistuu silmukasta.
            tulostaAlikomennot(aliTaso); // Kerrotaan tietoa käyttäjälle.
            suoritaKomento(aliTaso); // Suoritetaan itse komento.
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
        System.out.println(messageToUser);
        String syöte = this.syötteenLukija.nextLine();
        return syöte;
    }

    /**
     * Tarkistetaan onko annettu syöte päätason komento.
     *
     * @param syöte käyttäjän syöte.
     *
     * @return onko syöte sallittu?
     */
    public boolean onPääkomento(final String syöte) {
        if (!onEpänegatiivinenLuku(syöte)) {
            return false;
        }
        if (syöte.length() != Kayttoliittyma.PÄÄTASON_KOMENNON_PITUUS) { // Tarkista komennon pituus.
            return false;
        }
        int komento = Integer.valueOf(syöte); // Syöte luvuksi.
        // Tarkista, että että komento on sallitulla välillä [0, thisPÄÄTASON_KOMENTOJEN_LUKUMÄÄRÄ-1].
        if (komento < 0 || komento > Kayttoliittyma.PÄÄTASON_KOMENTOJEN_LUKUMÄÄRÄ - 1) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistetaan onko annettu syöte epänegatiivinen numero.
     *
     * @param syöte käyttäjän syöte.
     *
     * @return onko syöte epänegatiivinen numero?
     */
    public boolean onEpänegatiivinenLuku(final String syöte) {
        if (syöte == null) { // Tarkista, että viittaus on aito.
            return false;
        }
        if (syöte.length() <= 0) { // Tarkista pituus.
            return false;
        }
        if (!sisältääVainNumeroita(syöte)) { // Tarkista, että syöte koostuu numeroista.
            return false;
        }
        return true;
    }

    /**
     * Tarkistetaan onko annettu syöte positiivinen numero.
     *
     * @param syöte käyttäjän syöte.
     *
     * @return onko syöte positiivinen numero?
     */
    public boolean onPositiivinenLuku(final String syöte) {
        if (onEpänegatiivinenLuku(syöte) && !syöte.equals("0")) {
            // Jos syöte ei ole epänegatiivinen numero eikä nolla, on se positiivinen.
            return true;
        }
        return false;
    }

    /**
     * Tarkistetaan, että syöte sisältää vain numeroita.
     *
     * @param syöte käyttäjän syöte.
     *
     * @return onko syötteessä vain numeroita?
     */
    public boolean sisältääVainNumeroita(final String syöte) {
        for (int i = 0; i < syöte.length(); i++) { // Tarkista, että syötteessä on vain numeroita.
            if (!Character.isDigit(syöte.charAt(i))) {
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
     * @param syöte komento tekstimuodossa.
     *
     * @return komennon numero kokonaislukuna.
     */
    public int komennonArvo(final String syöte) {
        // Syötteen tarkistuksen tulisi estää, että muunnos kokonaisluvuksi ei epäonnistu koskaan.
        return Integer.valueOf(syöte);
    }

    /**
     * Suorita komento.
     *
     * @param komento komennon numero kokonaislukuna.
     */
    public void suoritaKomento(final int komento) {
        if (komento == 0) {
            sulje();
        } else if (komento == 1) {
            luoAvaimet();
        } else if (komento == 2) {
            viestiLukujenMuotoon();
        } else if (komento == 3) {
            lukuViestinMuotoon();
        } else if (komento == 4) {
            salaus();
        } else if (komento == 5) {
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
        AvaimenLuoja avaimenLuoja = new AvaimenLuoja();
        Avain avain = avaimenLuoja.luoAvaimet();
        System.out.println("Luodun avaimen arvot:");
        System.out.print("n: ");
        System.out.println(avain.getN().merkkijonoksi());
        System.out.print("e: ");
        System.out.println(avain.getE().merkkijonoksi());
        System.out.print("d: ");
        System.out.println(avain.getD().merkkijonoksi());
    }

    /**
     * Muutetaan viesti numeroiksi ja kerrotaan tulos käyttäjälle.
     */
    public void viestiLukujenMuotoon() {
        String syöte = lueSyöte("Luvuksi muutettava viesti: ");
        if (tarkistaPaluu(syöte)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }
        MerkkijonoMuutos stringConvert = new MerkkijonoMuutos();
        String numberForm = stringConvert.merkkijonoLukujenMuotoon(syöte);
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
        String syöte = lueSyöte("Viestiksi muutettava luku: ");
        if (tarkistaPaluu(syöte)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }
        if (onPositiivinenLuku(syöte)) {
            MerkkijonoMuutos stringConvert = new MerkkijonoMuutos();
            String messageForm = stringConvert.lukujenMuotoMerkkijonoksi(syöte);
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
        String syöteLuku = lueSyöte("Anna salattava viesti (numeroina): ");
        if (tarkistaPaluu(syöteLuku)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        String syöteE = lueSyöte("Anna julkinen avain (e): ");
        if (tarkistaPaluu(syöteE)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        String syöteN = lueSyöte("Anna osamäärä (n): ");
        if (tarkistaPaluu(syöteN)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        // Tarkistetaan syöte
        if (onPositiivinenLuku(syöteLuku) && onPositiivinenLuku(syöteN) && onPositiivinenLuku(syöteE)) {
            SalausPurku salausPurku = new SalausPurku(); // Uusi salausolio.
            Avain avain = new Avain(new SuuriLuku(syöteN), new SuuriLuku(syöteE), new SuuriLuku("0")); // Uusi avain.
            String salattu = salausPurku.salaus(avain, new SuuriLuku(syöteLuku)); // Varsinainen salaus.
            System.out.println("Viesti salatussa muodossa:\n" + salattu); // Kerrotaan käyttäjälle.
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
        String syöteLuku = lueSyöte("Anna salattu viesti (numeroina): ");
        if (tarkistaPaluu(syöteLuku)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        String syöteN = lueSyöte("Anna osamäärä (n): ");
        if (tarkistaPaluu(syöteN)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        String syöteD = lueSyöte("Anna yksityinen avain (d): ");
        if (tarkistaPaluu(syöteD)) { // Tarkistetaan haluaako käyttäjä poistua.
            return;
        }

        // Tarkistetaan syöte
        if (onPositiivinenLuku(syöteLuku) && onPositiivinenLuku(syöteN) && onPositiivinenLuku(syöteD)) {
            SalausPurku salausPurku = new SalausPurku(); // Uusi purkuolio.
            Avain avain = new Avain(new SuuriLuku(syöteN), new SuuriLuku("0"), new SuuriLuku(syöteD)); // Uusi avain.
            String purettu = salausPurku.purku(avain, new SuuriLuku(syöteLuku)); // Varsinainen purku.
            System.out.println("Viesti puretussa muodossa:\n" + purettu); // Kerrotaan käyttäjälle.
            this.jatkaAlitasonSilmukkaa = false; // Poistutaan alemman tason silmukasta.
        } else {
            System.out.println("Virheellinen syöte. Onhan syöte positiivinen luku?");
        }
    }

    /**
     * Tarkistetaan haluaako käyttäjä palata takaisin päätasolle.
     *
     * @param syöte käyttäjän syöte.
     *
     * @return palataanko takaisin päätasolle?
     */
    public boolean tarkistaPaluu(final String syöte) {
        if (syöte.equals("0")) {
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
     * @param aliTaso suoritettavan alitason komento kokonaislukuna.
     */
    public void tulostaAlikomennot(final int aliTaso) {
        // Kaikille alikomennoille yhteiset tulosteet.
        System.out.println("\nKomennot:");
        System.out.println("0 - Palaa takaisin.");
        // Komennnoilla 0 ja 1 ei ole ylimääräisiä alisilmukan tuloksia, sillä näihin ei voida jäädä pyörimään.
        if (aliTaso == 2) {
            System.out.println("Muutetaan viesti luvuksi. Muutos suoritetaan muuttamalla merkit Unicode arvoiksi."
                    + " Mikäli haluat käyttää jotain muuta muutostapaa, tee se toisessa sovelluksessa ja käytä tätä"
                    + " sovellusta vain purkuun ja salaukseen. Huomio myös, että viestin pituudelle on olemassa"
                    + " yläraja, joka riippuu käytettävän RSA-avaiment pituudesta.");
        } else if (aliTaso == 3) {
            System.out.println("Muutetaan luku viestiksi. Muutos toteutetaan tulkitsemalla luvut Unicode arvoina. "
                    + " Varmista, että alkuperäinen muutos on toteutettu Unicode arvoilla,"
                    + " muuten tämä muutos ei ole mielekäs.");
        } else if (aliTaso == 4) {
            System.out.println("Salataan viesti. Salaukseen tarvitaan julkinen avain ja osamäärä."
                    + " Huomioi, että viestin oltava lukuna.");
        } else if (aliTaso == 5) {
            System.out.println("Puretaan viesti. Purkamiseen tarvitaan yksityinen avain ja osamäärä."
                    + " Huomioi, että viestin on oltava lukuna.");
        }
    }
}
