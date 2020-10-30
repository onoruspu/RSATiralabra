
package RSA;

//import java.math.BigInteger;
import DataStructures.SlowLargeNumber;
import DataStructures.HorribleRandom;

public class RSA {
    
    /* - Some notes, clean this
    BigInteger p; // First prime
    BigInteger q; // Second prime
    BigInteger n; // n = p*q
    BigInteger phi; // https://en.wikipedia.org/wiki/Phi
    BigInteger d; // private key exponent, d=decrypt
    BigInteger e; // e = 3,5,17,257,65537 - public key exponent , e=encrypt
    // Encryption key is pair (e,n)
    // Decription key is pair (d,n)
    */
    
    private int size; // How big |p|+|q| should be. Currently no way to change this, no tests for compatibility and no validity checks.
    private SlowLargeNumber p;
    private SlowLargeNumber q;
    private SlowLargeNumber n;
    private SlowLargeNumber phi;
    private SlowLargeNumber d;
    private SlowLargeNumber e; // e=65537 ?, should we use int instead?
    
    // Set size
    public RSA(int size) {
        this.size = size;
    }
    
    // TODO temporary for god knows why
    public void launch() {
        System.out.println("launch");
        init();
    }
    
    private void init() {
        
        // TODO
        // Create p and q primes
        this.p = createPrime(this.size/2);
        //this.q = createPrime(this.size/2);
        
        // TODO
        
        // Create n
        
        // Create phi
        
        // Create d
        
        // Create e? int or SLN?
        
    }
    
    // TODO
    private SlowLargeNumber createPrime(int size) {
        SlowLargeNumber SLN = new SlowLargeNumber(size);
        
        // Something like:
        // SLN = createBits(size);
            // Can SLN.get(0) be 0 and is it a problem?
        // SLN = editUntilPrime(SLN);
        // primeCheck(SLN) ? (inside edit or in both?)
        
        SLN = createBits(size);
        
        // add +1 and check until prime
        
        /* - basic test
        for (int i=0; i<SLN.getSize(); i++) {
            System.out.print(SLN.getIndex(i));
        }
        */
        
        
        return SLN;
    }
    
    private SlowLargeNumber createBits(int size) {
        SlowLargeNumber SLN = new SlowLargeNumber(size);
        
        // Create numbers
        HorribleRandom hr = new HorribleRandom(2); // 2 for binary
        int[] bits = hr.createNBit(size);
        
        // Set numbers
        for (int i=0; i<size; i++) {
            SLN.setIndex(i, bits[i]);
        }
        
        return SLN;
    }
    
    // TODO - more methods
    
}

