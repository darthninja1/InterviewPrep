package bits;

// https://leetcode.com/problems/reverse-integer/
// https://www.geeksforgeeks.org/reverse-digits-integer-overflow-handled/
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse(98765));
        System.out.println(reverse(0));
        System.out.println(reverse(11));
        System.out.println(reverse(1000034));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    private static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = Math.abs(x);
        }
        int reversed = 0;
        int prev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            reversed = reversed * 10 + digit;
            if ((reversed - digit) / 10 != prev) {
                System.out.print("Error overflow ");
                return -1;
            }
            prev = reversed;
        }
        return negative ? 0 - reversed : reversed;
    }
}
