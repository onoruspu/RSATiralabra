
/*
 * SuuriLuku-olion tarkoituksena on tarjota toiminallisuus suurien lukujen käsittelyyn.
 * Tavoitteena olisi, että SuuriLuku-olio voisi korvata Javan BigInteger-toteutuksen.
 * Tällä hetkellä BigInteger on leivottu SuuriLuku-luokan sisään, jotta voidaan varmistua
 * että kaikki toimnallisuudet ovat aina olemassa, mutta luodessa uusia toiminallisuuksia
 * ei jatkuvasti tarvitse korvata BigInteger toteutuksia muissa luokissa.
 */

package tietorakenteet;

import apu.Taulukko;
import java.math.BigInteger; // Katso ylempää, miksi näin tehdään.
                             // Tavotteena olisi niin laaja toteutus, että importtia ei tarvita.
import java.util.Random; // Satunnaisuus tarvitaan alkulukujen luontiin.
                         // Myöhemmin tarkoitus korvata omalla toteutuksella.

public class SuuriLuku {
    /**
     * Numerot, joista luku muodstoo. Kantalukuna on 10.
     */
    private int[] numerot;

    /**
     * SuuriLuku-olion sisään leivottu BigInteger-olio. Riittävän laajalla toteutuksella tämä käy tarpeettomaksi.
     */
    private BigInteger bigInt;

    /**
     * Tämänhetkinen alkuluku e:n arvo.
     */
    private static final int PRIME_E = 65537;

    /**
     * Tyhjä konstruktori.
     */
    public SuuriLuku() {
    }

    /**
     * Konstruktori, jossa merkkijono antaa SuuriLuku-olion numeerisen arvon.
     *
     * @param lukuMerkkijonona Sisältää numeerisen arvon merkkijonon muodossaa.
     */
    public SuuriLuku(final String lukuMerkkijonona) {
        this.numerot = new int[lukuMerkkijonona.length()];
        for (int i = 0; i < lukuMerkkijonona.length(); i++) {
            this.numerot[i] = lukuMerkkijonona.charAt(i) - '0'; // charAt antaa ASCII-arvoja(?), joten
                                                                // Vähennetään '0' saadaksemme numeerisia arvoja.
        }
        päivitäBigInt();
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Luo uusi todennäköinen alkuluku, jonka pituus saadaan parametrina.
     *
     * @param alkuluvunKoko Alkuluvun bittipituus.
     *
     * @return SuuriLuku, joka on todennäköinen alkuluku.
     */
    public SuuriLuku uusiAlkuluku(final int alkuluvunKoko) {
        return new SuuriLuku(BigInteger.probablePrime(alkuluvunKoko, new Random()).toString());
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Kertolasku kahdelle SuurelleLuvulle.
     *
     * @param kerrottava Mikä kerrotaan.
     *
     * @param kertoja Millä kerrotaan.
     *
     * @return Kertolaskun tulos.
     */
    public SuuriLuku kertolasku(final SuuriLuku kerrottava, final SuuriLuku kertoja) {
        return new SuuriLuku(kerrottava.bigInt.multiply(kertoja.bigInt).toString());
    }

    /**
     * Vähennetään SuuriLuku-olion arvosta yksi (1).
     * Negatiiviset luvut eivät kuitenkaan ole sallittuja.
     */
    public void yhdenPienempi() {
        // Mikäli ollaan jo nollassa, ei mitään tarvitse tehdä.
        if (!this.samaLukuArvo(new SuuriLuku("0"))) {
            int viimeinenIndeksi = this.numerot.length - 1; // Tarpeeton muuttuja, mutta helpottaa koodin lukua.
            if (this.numerot[viimeinenIndeksi] == 0) { // Mikäli viimeinen numero on nolla, tulee miettiä sen
                                                       // vähentämisen vaikutuksia muihinkin numeroihin.
                int eiNollatLaskuri = 1; // Pidetään kirjaa muista kuin nollien määräst.
                for (int i = 1; i < this.numerot.length; i++) { // i=1, sillä viimeinen arvo on jo tarkistettu yllä.
                    if (this.numerot[this.numerot.length - 1 - i] != 0) {
                        break; // Jos löytyy yksikin ei-nolla, ei tarkistusta tarvitse enään jatkaa.
                    } else {
                        eiNollatLaskuri++;
                    }
                }
                if (eiNollatLaskuri != this.numerot.length) { // Mikäli tämä olisi tosi, olisi kaikki luvut nollia,
                                                              // jolloin emme halua vähentää mitään.
                    for (int i = 0; i < eiNollatLaskuri; i++) { // Asetetaan kaikki nollat yhdeksään (10-1=9).
                        this.numerot[this.numerot.length - 1 - i] = 9;
                    }
                    this.numerot[this.numerot.length - 1 - eiNollatLaskuri] -= 1; // Korjataan nollien jälkeinen numero.
                }
            } else {
                this.numerot[viimeinenIndeksi] -= 1; // Triviaali tapaus, kun viimeinen luku ei ole nolla.
            }
            if (this.numerot[0] == 0) {
                this.poistaAlunNollat(); // Siivotaan nollat alusta.
            }
            päivitäBigInt(); // Pidetään bigInt ajan tasalla.
        }
    }

    /**
     * Palauta SuuriLuku-olion sisäinen BigInteger-olio.
     *
     * @return BigInteger-olio, jonka arvo vastaa SuuriLuku-olion arvoa.
     */
    // Metodi on yksityinen, sillä muilla luokilla ei tarvitse olla pääsyä BigInteger-olioon.
    private BigInteger getBigInt() {
        return this.bigInt;
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Palautetaan alkuluku e.
     *
     * @return alkuluku e.
     */
    public SuuriLuku e() {
        return new SuuriLuku(new BigInteger("" + PRIME_E).toString());
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Palautetaan SuuriLuku-olion käänteisluvun jakojäännös.
     *
     * @param käsiteltäväLuku Luku, josta halutaan jakojäännösKäänteisluku.
     *
     * @param jakojäännös Luku, joka toimii jakojäännöksen laskussa.
     *
     * @return Käänteisluvun jakojäännös.
     */
    public SuuriLuku jakojäännösKäänteisluku(final SuuriLuku käsiteltäväLuku, final SuuriLuku jakojäännös) {
        return new SuuriLuku(käsiteltäväLuku.getBigInt().modInverse(jakojäännös.getBigInt()).toString());
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Palautetaan luvun potenssin jakojäännös.
     *
     * @param eksponentti Laskun potenssi.
     *
     * @param jakojäännös Laskun jakaja.
     *
     * @return Luvun potenssin jakojäännös.
     */
    public SuuriLuku jakojäännösPotenssi(final SuuriLuku eksponentti, final SuuriLuku jakojäännös) {
        return new SuuriLuku(this.getBigInt().modPow(eksponentti.getBigInt(), jakojäännös.getBigInt()).toString());
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Palautetaan SuuriLuku-olion binäärisen arvon pituus.
     *
     * @return Kokonaisluku bittipituus.
     */
    public int bittiPituus() {
        return this.getBigInt().bitLength();
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Tieto siitä, onko lukujen numeerinen arvo identtinen.
     *
     * @param verrattava Luku, jota verrataan.
     *
     * @return Totuusarvo siitä ovatko lukujen arvot samat.
     */
    public boolean samaLukuArvo(final SuuriLuku verrattava) {
        return this.getBigInt().equals(verrattava.getBigInt());
    }

    /**
     * Palauta SuuriLuku-olion numeerinen arvo merkkijonona. Kantalukuna on 10.
     *
     * @return Merkkijono numeerisesta arvosta.
     */
    public String merkkijonoksi() {
        String s = ""; // StringBuilder olisi nopeampi, mutta haluamme välttää valmiita luokkia.
        for (int i = 0; i < numerot.length; i++) {
            s += this.numerot[i];
        }
        return s;
    }

    /**
     * Poistetaan luvun alussa olevat numeerisesti tarpeettomat nollat (00001 = 1).
     */
    public void poistaAlunNollat() {
        int nollaLaskuri = 0; // Pidetään kirjaa nollien määrästä.
        for (int i = 0; i < numerot.length; i++) {
            if (numerot[i] == 0) {
                nollaLaskuri++;
            } else {
                break; // Silmukka voidaan lopettaa, mikäli löydetään yksi ei-nolla.
            }
        }
        if (nollaLaskuri == numerot.length) {
            // Poikkeustilanteessa kaikki numerot ovat nollia, jolloin palautamme nollan.
            this.numerot = new int[]{0};
        } else {
            Taulukko taulukko = new Taulukko(); // Apuolio.
            this.numerot = taulukko.kopioiTaulukkoVälillä(numerot, nollaLaskuri, numerot.length - 1);
        }
        päivitäBigInt(); // PÄivitetään bigInt-arvo.
    }

    /**
     * Päivitetään BigInteger samaan numeriseen arvoon kuin SuuriLuvun numerot.
     * Mikäli muutetaan numeroita, tulee pitää myös BigInteger-olion arvo samana,
     * jotta voidaan pitää kumpikin tietorakenne samassa arvossa.
     */
    // Metodi on puhtaasti luokan sisäinen, joten se on määritetty yksityiseksi.
    private void päivitäBigInt() {
        this.bigInt = new BigInteger(this.merkkijonoksi());
    }
}
