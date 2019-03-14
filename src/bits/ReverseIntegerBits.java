package bits;

// https://www.programcreek.com/2014/03/leetcode-reverse-bits-java/
// https://www.geeksforgeeks.org/reverse-actual-bits-given-number/
public class ReverseIntegerBits {
    public static void main(String[] args) {
        int num = 0xC0C0C0C0;
        int reversed = reverse(num);
        System.out.println(Integer.toBinaryString(num) + " -> " + Integer.toBinaryString(reversed));

        num = 0xFFFFFFFF;
        reversed = reverse(num);
        System.out.println(Integer.toBinaryString(num) + " -> " + Integer.toBinaryString(reversed));

        num = 0xF0F0F0F0;
        reversed = reverseEfficient(num);
        System.out.println(Integer.toBinaryString(num) + " -> " + Integer.toBinaryString(reversed));
    }

    private static int reverse(int x) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int t = x & (1 << i);
            if (t != 0) {
                result |= 1 << (31 - i);
            }
        }
        return result;
    }

    private static int reverseEfficient(int x) {
        for (int i = 0; i < 16; i++) {
            int lowOrderBit = (x >> i) & 1;
            int highOrderBit = (x >> (31 - i)) & 1;
            if (highOrderBit != lowOrderBit) { // or highOrderBit ^ lowOrderBit != 0
                // This takes some time to understand
                // Essentially 0 ^ 1 = 1 and 1 ^ 1 = 0;
                x ^= ((1 << i) | (1 << (31 - i)));
            }
        }
        return x;
    }
}
