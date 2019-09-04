package Binary;

public class NumberOf1Bits {

    public static void main(String args[]) {
        int n = 5;
        System.out.println(hammingWeight(n));
    }

    /*
        We check each of the 32 bits of the number. If the bit is 1, we add one to the number of 1-bits.
        We can check the i th bit of a number using a bit mask.
        We start with a mask m=1, because the binary representation of 1 is,
        0000 0000 0000 0000 0000 0000 0000 0001

         Clearly, a logical AND between any number and the mask 11 gives us the least significant bit of this number.
          To check the next bit, we shift the mask to the left by one.

     */
    public static int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

}
