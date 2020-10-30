
// This class should offer same things as Java's BigInteger but not in general way, only for this software.

package DataStructures;

// TODO everything
public class SlowLargeNumber {
    // What does this contain?
    // Massive array? Or something else?
    private int[] numbers;
    private int limit; // For controlling length if necessary.
    
    public SlowLargeNumber(int size) {
        this.numbers = new int[size];
        this.limit = -1; // -1 means no limit. Limit isn't always necessary so -1 will be the default.
    }
    
    // TODO
    public void setIndex(int index, int value) {
        // Check that index is in range
        // Check that value is 0 or 1
        // Make robust checks at UI level not here
        // Exceptions can't really be handled, they're going to crash the software
        this.numbers[index] = value;
    }
    
    public int getIndex(int index) {
        // Check that index is in range
        return this.numbers[index];
    }
    
    public int getSize() {
        return this.numbers.length;
    }
    
    public void setLimit(int limit) {
        this.limit = limit;
    }
    
    // TODO - addition
    public void addOne() {
        // Trivial case when last bit is 0
        if (this.numbers[this.numbers.length] == 0) {
            this.numbers[this.numbers.length] = 0;
        } else {
            // Loop sum until we find 0 <=> until carry == 0
            int carry = 1; // We add one and the last bit is 1 so carry starts from 1.
            while (carry == 1) {
                
            }
            // Check for going over limit
        }
    }
    
    // TODO - multiplication
    
    // TODO - power
    
    // TODO - powermodulo
}
