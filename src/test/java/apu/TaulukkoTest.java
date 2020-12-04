
package apu;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Testiluokka Taulukko-luokalle.
 */
public class TaulukkoTest {
    /**
     * Testausolio luokalle.
     */
    private final Taulukko taulukkoLuokka = new Taulukko();

    /**
     * Testitaulukko.
     */
    private final int[] taulukko = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    /**
     * Varmistetaan, että kopioiTaulukkoVälillä-metodi antaa oikein kokeisen taulukon.
     */
    @Test
    public void kopioiTaulukkoVälilläKokoOikein() {
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 0, 5).length == 6);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 0, 9).length == 10);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 5, 9).length == 5);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 3, 5).length == 3);
    }

    /**
     * Varmistetaan, että kopioiTaulukkoVälillä-metodi antaa oikein taulukon oikeilla arvoilla.
     */
    @Test
    public void kopioiTaulukkoVälilläSisältöOikein() {
        // Tarpeetonta metodin toistoa, mutta toimii.
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 0, 5)[0] == 1);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 0, 5)[5] == 6);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 0, 9)[0] == 1);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 0, 9)[9] == 0);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 5, 9)[0] == 6);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 5, 9)[4] == 0);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 3, 5)[0] == 4);
        assertTrue(this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, 3, 5)[2] == 6);
    }

    /**
     * Varmistetaan, että liian pieni alkuIndeksi heittää IllegalArgumentException-poikkeuksen.
     */
    @Test(expected = IllegalArgumentException.class)
    public void kopioiTaulukkoVälilläVääräAlkuIndeksiParametriHeittääVirheen() {
        this.taulukkoLuokka.kopioiTaulukkoVälillä(this.taulukko, -1, 5);
    }


    /**
     * Varmistetaan, että liian suuri loppuIndeksi heittää IllegalArgumentException-poikkeuksen.
     */
    @Test(expected = IllegalArgumentException.class)
    public void kopioiTaulukkoVälilläVääräLoppuIndeksiParametriHeittääVirheen() {
        this.taulukkoLuokka.kopioiTaulukkoVälillä(taulukko, 0, this.taulukko.length + 1);
    }

    /**
     * Varmistetaan, että taulukko saadaan käännetyksi.
     */
    @Test
    public void taulukkoTakaperinTest() {
        int[] taulukkoTilapäinen = this.taulukkoLuokka.taulukkoTakaperin(this.taulukko);
        assertTrue(taulukkoTilapäinen[0] == 0); // Nollaa ei saada järkevästi tarkistettua silmukalla,
                                                // joten tarkistetaan se erikseen.
        for (int i = 1; i < this.taulukko.length; i++) {
            assertTrue(taulukkoTilapäinen[i] == this.taulukko.length - i);
        }

        int[] taulukkoNolla = this.taulukkoLuokka.taulukkoTakaperin(new int[]{0});
        assertTrue(taulukkoNolla.length == 1);
        assertTrue(taulukkoNolla[0] == 0);
    }
}
