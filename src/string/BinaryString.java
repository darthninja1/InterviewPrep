package string;

public class BinaryString {
    public static void main(String[] args) {
        System.out.println(minimumFlips("101010101") == 0);
        System.out.println(minimumFlips("001") == 1);
        System.out.println(minimumFlips("0001010111") == 2);
        System.out.println(minimumFlips("11100111000") == 5);
        System.out.println(minimumFlips("101010101") == 0);
        System.out.println(minimumFlips("0000") == 2);
        System.out.println(minimumFlips("0") == 0);
        System.out.println(minimumFlips("000") == 1);
    }

    /**
     * 1. Calculate flips with 1st bit as 0
     * 2. Calculate flips with 1st bit as 1
     * 3. Return minimum of 1 & 2
     */
    private static int minimumFlips(String s) {
        int count1 = flip(s, '1');
        int count2 = flip(s, '0');
        return Math.min(count1, count2);
    }

    private static int flip(String s, char expected) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != expected) {
                count++;
            }
            expected = expected == '0' ? '1' : '0';
        }
        return count;
    }
}