
package avain;

import java.math.BigInteger;

/**
 * Viestin salaus ja purku.
 */
public class SalausPurku {
    /**
     * Salaa viesti.
     *
     * @param key avain salaukseen.
     *
     * @param message salattava viesti.
     *
     * @return salattu viesti.
     */
    public String salaus(final Avain key, final BigInteger message) {
        BigInteger encoded = message.modPow(key.getE(), key.getN()); // Salaus.
        return encoded.toString();
    }

    /**
     * Pura viesti.
     *
     * @param key avain purkuun.
     *
     * @param message purettava viesti.
     *
     * @return purettu viesti.
     */
    public String purku(final Avain key, final BigInteger message) {
        BigInteger decoded = message.modPow(key.getD(), key.getN()); // Purku.
        return decoded.toString();
    }




}
