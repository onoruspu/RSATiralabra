
// Linear congruential genarator LCG - https://en.wikipedia.org/wiki/Linear_congruential_generator
// Inspiration from https://stackoverflow.com/questions/13442611/how-can-i-generate-a-random-number-without-use-of-math-random

package DataStructures;

// Create numbers that might or might not be random
public class HorribleRandom {
    private int max, previous;
    
    public HorribleRandom(int max) {
        this.max = max;
        this.previous = (int) (System.currentTimeMillis() % this.max);
    }
    
    public int next() {
        this.previous = (this.previous * 32718 + 3) % 32749; // Constant variables from Frank - https://stackoverflow.com/users/1651073/frank
        return this.previous % this.max;
    }

    public int[] createNBit(int size) {
        int[] bits = new int[size];
        int maxTemp = this.max; // Temporary save
        this.max = 2; // For creating bits - 0 or 1
        for (int i=0; i<size; i++) {
            bits[i] = next();
        }
        this.max = maxTemp; // Return original value
        return bits;
    }
    
}
