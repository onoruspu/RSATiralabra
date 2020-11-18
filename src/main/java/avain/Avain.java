package avain;

import tietorakenteet.SuuriLuku;

/**
 * Avainten hallinta.
 */
public class Avain {
    /**
     * Jakojäännös.
     */
    private SuuriLuku n;

    /**
     * Julkinen avain.
     */
    private SuuriLuku e;

    /**
     * Yksityinen avain.
     */
    private SuuriLuku d;

    /**
     * Konstruktori, jolla asetetaan avaimelle sen arvot.
     *
     * @param newN osamäärä (n).
     *
     * @param newE julkinen avain (e).
     *
     * @param newD yksityinen avain (d).
     */
    public Avain(final SuuriLuku newN, final SuuriLuku newE, final SuuriLuku newD) {
        this.n = newN;
        this.e = newE;
        this.d = newD;
    }

    /**
     * Palauta avaimen jakojäännös (n).
     *
     * @return avaimen jakojäännös (n).
     */
    public SuuriLuku getN() {
        return this.n;
    }

    /**
     * Palauta julkinen avain (e).
     *
     * @return julkinen avain (e).
     */
    public SuuriLuku getE() {
        return this.e;
    }

    /**
     * Palauta yksityinen avain (d).
     *
     * @return yksityinen avain (d).
     */
    public SuuriLuku getD() {
        return this.d;
    }

    /**
     * Aseta avaimen jakojäännös (n).
     *
     * @param uusiN avaimen jakojäännös (n).
     */
    public void setN(final SuuriLuku uusiN) {
        this.n = uusiN;
    }

    /**
     * Aseta julkinen avain (e).
     *
     * @param uusiE julkinen avain (e).
     */
    public void setE(final SuuriLuku uusiE) {
        this.e = uusiE;
    }

    /**
     * Aseta yksityinen avain (d).
     *
     * @param uusiD yksityinen avain (d).
     */
    public void setD(final SuuriLuku uusiD) {
        this.d = uusiD;
    }
}
