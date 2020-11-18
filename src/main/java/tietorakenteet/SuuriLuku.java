
/**
 * SuuriLuku-olion tarkoituksena on tarjota toiminallisuus suurien lukujen käsittelyyn.
 * Tavoitteena olisi, että SuuriLuku-olio voisi korvata Javan BigInteger-toteutuksen.
 * Tällä hetkellä BigInteger on leivottu SuuriLuku-luokan sisään, jotta voidaan varmistua
 * että kaikki toimnallisuudet ovat aina olemassa, mutta luodessa uusia toiminallisuuksia
 * ei jatkuvasti tarvitse korvata BigInteger toteutuksia muissa luokissa.
 */
package tietorakenteet;

import java.math.BigInteger; // Katso ylempää, miksi näin tehdään.
                             // Tavotteena olisi niin laaja toteutus, että importtia ei tarvita.
import java.util.Random; // Satunnaisuus tarvitaan alkulukujen luontiin.
                         // Myöhemmin tarkoitus korvata omalla toteutuksella.

public class SuuriLuku {
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
     * Konstruktori BigInteger-olion kautta.
     *
     * @param bigIntOlio BigInteger-olio, joka antaa SuuriLuku-oliolle sen numeerisen arvon.
     */
    public SuuriLuku(final BigInteger bigIntOlio) {
        this.bigInt = bigIntOlio;
    }

    /**
     * Konstruktori, jossa merkkijono antaa SuuriLuku-olion numeerisen arvon.
     *
     * @param lukuMerkkijonona sisältää numeerisen arvon merkkijonon muodossaa.
     */
    public SuuriLuku(final String lukuMerkkijonona) {
        this.bigInt = new BigInteger(lukuMerkkijonona);
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
        return new SuuriLuku(BigInteger.probablePrime(alkuluvunKoko, new Random()));
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
        return new SuuriLuku(kerrottava.bigInt.multiply(kertoja.bigInt));
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Vähennetään SuuriLuku-olion arvosta yksi (1).
     * Negatiiviset luvut eivät kuitenkaan ole sallittuja.
     *
     * @param suuriLuku Mistä vähenetään.
     *
     * @return SuuriLuku-olio yhden pienemmällä arvolla.
     */
    public SuuriLuku yhdenPienempi(final SuuriLuku suuriLuku) {
        return new SuuriLuku(suuriLuku.bigInt.subtract(BigInteger.ONE));
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
        return new SuuriLuku(new BigInteger("" + PRIME_E));
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
        return new SuuriLuku(käsiteltäväLuku.getBigInt().modInverse(jakojäännös.getBigInt()));
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
        return new SuuriLuku(this.getBigInt().modPow(eksponentti.getBigInt(), jakojäännös.getBigInt()));
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
     * @param verrattava Luku, johon verrataan.
     *
     * @param vertailtava Luku, jota verrataan.
     *
     * @return Totuusarvo siitä ovatko lukujen arvot samat.
     */
    public boolean samaLukuArvo(final SuuriLuku verrattava, final SuuriLuku vertailtava) {
        return verrattava.getBigInt().equals(vertailtava.getBigInt());
    }

    // TODO - korvaa omalla toteutuksella.
    /**
     * Palauta SuuriLuku-olion numeerinen arvo merkkijonona.
     *
     * @return merkkijono numeerista arvosta.
     */
    public String merkkijonoksi() {
        return this.bigInt.toString();
    }
}
