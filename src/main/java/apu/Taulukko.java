
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
}
