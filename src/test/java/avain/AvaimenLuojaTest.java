
package avain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import tietorakenteet.SuuriLuku;

/**
 * Testiluokka AvaimenLuoja-luokalle.
 */
public class AvaimenLuojaTest {
    /**
     * Pienin sallittu alkuluku n:n bittipituus.
     */
    private static final int PIENIN_SALLITTU_N_BITTIPITUUS = 1;

    /**
     * Pienin sallittu alkulku e:n bittipituus.
     */
    private static final int PIENIN_SALLITTU_E_BITTIPITUUS = 1;

    /**
     * Pienin sallittu alkuluku d:n bittipituus.
     */
    private static final int PIENIN_SALLITTU_D_BITTIPITUUS = 1;

    /**
     * Testi luoAvaimet-metodille.
     */
    @Test
    public void avaimenLuojaTesti() {
        AvaimenLuoja avaimenLuoja = new AvaimenLuoja();
        Avain avain = avaimenLuoja.luoAvaimet();
        assertFalse(avain.getN().equals(new SuuriLuku("-1")));
        assertFalse(avain.getE().equals(new SuuriLuku("-1")));
        assertFalse(avain.getD().equals(new SuuriLuku("-1")));
        assertFalse(avain.getN().equals(new SuuriLuku("0")));
        assertFalse(avain.getE().equals(new SuuriLuku("0")));
        assertFalse(avain.getD().equals(new SuuriLuku("0")));
        assertFalse(avain.getN().equals(avain.getE()));
        assertFalse(avain.getN().equals(avain.getD()));
        assertFalse(avain.getD().equals(avain.getE()));
        assertTrue(avain.getN().bittiPituus() > PIENIN_SALLITTU_N_BITTIPITUUS);
        assertTrue(avain.getE().bittiPituus() > PIENIN_SALLITTU_E_BITTIPITUUS);
        assertTrue(avain.getD().bittiPituus() > PIENIN_SALLITTU_D_BITTIPITUUS);
    }
}
