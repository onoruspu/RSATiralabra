
package avain;

import java.math.BigInteger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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
     * Testi testKeyGenerator-metodille.
     */
    @Test
    public void avaimenLuojaTesti() {
        AvaimenLuoja keyGenerator = new AvaimenLuoja();
        Avain key = keyGenerator.luoAvaimet();
        assertFalse(key.getN().equals(new BigInteger("-1")));
        assertFalse(key.getE().equals(new BigInteger("-1")));
        assertFalse(key.getD().equals(new BigInteger("-1")));
        assertFalse(key.getN().equals(new BigInteger("0")));
        assertFalse(key.getE().equals(new BigInteger("0")));
        assertFalse(key.getD().equals(new BigInteger("0")));
        assertFalse(key.getN().equals(key.getE()));
        assertFalse(key.getN().equals(key.getD()));
        assertFalse(key.getD().equals(key.getE()));
        assertTrue(key.getN().bitLength() > PIENIN_SALLITTU_N_BITTIPITUUS);
        assertTrue(key.getE().bitLength() > PIENIN_SALLITTU_E_BITTIPITUUS);
        assertTrue(key.getD().bitLength() > PIENIN_SALLITTU_D_BITTIPITUUS);
    }
}
