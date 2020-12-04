
package apu;

/**
 * Työkaluja taulukoiden käsittelyyn.
 */
public class Taulukko {
    /**
     * Tyhjä konstuktori.
     */
    public Taulukko() {
    }

    /**
     * Kopioi kokonaislukutaulukosta arvot joltain väliltä.
     *
     * @param taulukko Kokonaislukutaulukko, josta arvot halutaan.
     *
     * @param alkuIndeksi Ensimmäisen arvon indeksi.
     *
     * @param loppuIndeksi Viimeisen arvon indeksi.
     *
     * @return Kokonaislukutalukko, joka sisältää arvot indekseistä ja niiden välistä.
     */
    public int[] kopioiTaulukkoVälillä(final int[] taulukko, final int alkuIndeksi, final int loppuIndeksi) {
        if (alkuIndeksi < 0 || loppuIndeksi > taulukko.length - 1) {
            throw new IllegalArgumentException();
        }
        int[] uusiTaulukko = new int[loppuIndeksi - alkuIndeksi + 1]; // Taulukon alustus.
        for (int i = 0; i < uusiTaulukko.length; i++) {
            uusiTaulukko[i] = taulukko[i + alkuIndeksi]; // Lisätään kopioitavat arvot.
        }
        return uusiTaulukko;
    }

    /**
     * Kopioi taulukko niin, että alkioit ovat takaperoisessa järjestyksessä.
     *
     * @param taulukko Kopioitava taulukko.
     *
     * @return Taulukon alkiot käännettynä.
     */
    public int[] taulukkoTakaperin(final int[] taulukko) {
        if (taulukko.length == 0) { // Mikäli paremetrina tyhjä taulukko.
            return new int[]{0};
        }
        int[] taulukkoKäännetty = new int[taulukko.length]; // Palautetttava.
        for (int i = 0; i < taulukko.length; i++) {
            taulukkoKäännetty[i] = taulukko[taulukko.length - 1 - i]; // Indeksit lopusta lähtien.
        }
        return taulukkoKäännetty;
    }
}
