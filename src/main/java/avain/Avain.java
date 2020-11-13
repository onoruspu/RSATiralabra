package avain;

import java.math.BigInteger;

/**
 * Avainten hallinta.
 */
public class Avain {
    /**
     * Jakojäännös.
     */
    private BigInteger n;

    /**
     * Julkinen avain.
     */
    private BigInteger e;

    /**
     * Yksityinen avain.
     */
    private BigInteger d;

    /**
     * Konstruktori, jolla asetetaan avaimelle sen arvot.
     *
     * @param newN osamäärä (n).
     * @param newE julkinen avain (e).
     * @param newD yksityinen avain (d).
     */
    public Avain(final BigInteger newN, final BigInteger newE, final BigInteger newD) {
        this.n = newN;
        this.e = newE;
        this.d = newD;
    }

    /**
     * Palauta avaimen jakojäännös (n).
     *
     * @return avaimen jakojäännös (n).
     */
    public BigInteger getN() {
        return this.n;
    }

    /**
     * Palauta julkinen avain (e).
     *
     * @return julkinen avain (e).
     */
    public BigInteger getE() {
        return this.e;
    }

    /**
     * Palauta yksityinen avain (d).
     *
     * @return yksityinen avain (d).
     */
    public BigInteger getD() {
        return this.d;
    }

    /**
     * Aseta avaimen jakojäännös (n).
     *
     * @param newN avaimen jakojäännös (n).
     */
    public void setN(final BigInteger newN) {
        this.n = newN;
    }

    /**
     * Aseta julkinen avain (e).
     *
     * @param newE julkinen avain (e).
     */
    public void setE(final BigInteger newE) {
        this.e = newE;
    }

    /**
     * Aseta yksityinen avain (d).
     *
     * @param newD yksityinen avain (d).
     */
    public void setD(final BigInteger newD) {
        this.d = newD;
    }
}
