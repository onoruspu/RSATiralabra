
package avain;

import java.math.BigInteger;
import java.util.Random;

/**
 * Avainten luonti.
 */
public class AvaimenLuoja {
    /**
     * Tämänhetkinen alkulukujen p ja q koko bitteinä.
     */
    private static final int ALKULUVUN_KOKO = 1024;

    /**
     * Luo uusi avain (n,e,d).
     *
     * @return Avaimen, joka sisältää julkisen ja yksityisen avaimen tiedot (n,e,d).
     */
    public Avain luoAvaimet() {
        // Alkuluku p.
        BigInteger p = BigInteger.probablePrime(ALKULUVUN_KOKO, new Random());

        // Alkuluku q.
        BigInteger q = BigInteger.probablePrime(ALKULUVUN_KOKO, new Random());

        // Jakonäännös n.
        BigInteger n = p.multiply(q);

        // Fii (engl. phi).
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // e - julkinen avain
        BigInteger e = new BigInteger("65537");

        // d - yksityinen avain.
        BigInteger d = e.modInverse(phi);

        return new Avain(n, e, d);
    }

}
