
package rsa;

import java.math.BigInteger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KeyGeneratorTest {
    
    @Test
    public void testKeyGenerator() {
        KeyGenerator keyGenerator = new KeyGenerator();
        Key key = keyGenerator.createKeys();
        assertFalse(key.getN().equals(new BigInteger("-1")));
        assertFalse(key.getE().equals(new BigInteger("-1")));
        assertFalse(key.getD().equals(new BigInteger("-1")));
        assertFalse(key.getN().equals(new BigInteger("0")));
        assertFalse(key.getE().equals(new BigInteger("0")));
        assertFalse(key.getD().equals(new BigInteger("0")));
        assertFalse(key.getN().equals(key.getE()));
        assertFalse(key.getN().equals(key.getD()));
        assertFalse(key.getD().equals(key.getE()));
        assertTrue(key.getN().bitLength()>100);
        assertTrue(key.getE().bitLength()>1);
        assertTrue(key.getD().bitLength()>100);
    }
}
