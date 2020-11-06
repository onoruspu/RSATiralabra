
package rsa;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
    
    /**
     * 
     * @return Key joka sisältää julkisen ja yksityisen avaimen tiedot (n,e,d).
     */
    public Key createKeys() {
        // Alkuluku p.
        BigInteger p = BigInteger.probablePrime(1024, new Random());
        
        // Alkuluku q.
        BigInteger q = BigInteger.probablePrime(1024, new Random());
        
        // Jakonäännös n.
        BigInteger n = p.multiply(q);
        
        // Fii (engl. phi).
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        
        // e - julkinen avain
        BigInteger e = new BigInteger("65537");
        
        // d - yksityinen avain.
        BigInteger d = e.modInverse(phi);
        
        return new Key(n, e, d);
    }
    
}
