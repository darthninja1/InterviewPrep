package bits;

// https://www.geeksforgeeks.org/how-to-turn-off-a-particular-bit-in-a-number/
public class ClearKthBit {
    public static void main(String[] args) {
        clear(15, 1);
        clear(15, 3);
        clear(255, 4);
        clear(512, 10);
    }

    private static void clear(int num, int k) {
        int ans = num & ~(num & 1 << (k - 1));
        System.out.println("Original number: " + num + " (" + Integer.toBinaryString(num) + "), clearing bit " + k + ": " + ans + " (" + Integer.toBinaryString(ans) + ")");
    }
}
