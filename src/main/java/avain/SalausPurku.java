
package avain;

import tietorakenteet.SuuriLuku;

/**
 * Viestin salaus ja purku.
 */
public class SalausPurku {
    /**
     * Salaa viesti.
     *
     * @param avain avain salaukseen.
     *
     * @param viesti salattava viesti.
     *
     * @return salattu viesti.
     */
    public String salaus(final Avain avain, final SuuriLuku viesti) {
        return viesti.jakojäännösPotenssi(avain.getE(), avain.getN()).merkkijonoksi(); // Salaus.
    }

    /**
     * Pura viesti.
     *
     * @param avain avain purkuun.
     *
     * @param viesti purettava viesti.
     *
     * @return purettu viesti.
     */
    public String purku(final Avain avain, final SuuriLuku viesti) {
        return viesti.jakojäännösPotenssi(avain.getD(), avain.getN()).merkkijonoksi(); // Purku.
    }

}
