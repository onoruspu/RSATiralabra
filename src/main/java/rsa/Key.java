
package rsa;

import java.math.BigInteger;

public class Key {
    private BigInteger n; // Jakojäännös.
    private BigInteger e; // Julkinen avain.
    private BigInteger d; // Yksityinen avain.
    // Julkinen avain muodostuu kokonaisuudessaan parista (e,n) ja 
    // yksityinsen avain parista (d,n).
    
    /**
     * Konstruktori, jolla asetetaan avaimelle sen arvot.
     * 
     * @param n avaimen koko binäärinä.
     * @param e julkinen avain.
     * @param d yksityinen avain.
     */
    public Key(BigInteger n, BigInteger e, BigInteger d) {
        this.n = n;
        this.e = e;
        this.d = d;
    }
    
    /**
     * Palauta avaimen koko binäärinä.
     * 
     * @return n avaimen koko binäärinä.
     */
    public BigInteger getN() {
        return this.n;
    }
    
    /**
     * Palauta julkinen avain.
     * 
     * @return n julkinen avain.
     */
    public BigInteger getE() {
        return this.e;
    }
    
    /**
     * Palauta yksityinen avain.
     * 
     * @return n yksityinen avain.
     */
    public BigInteger getD() {
        return this.d;
    }
}
