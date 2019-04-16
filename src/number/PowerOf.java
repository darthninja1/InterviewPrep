package number;

import com.google.common.math.DoubleMath;

// https://www.geeksforgeeks.org/check-if-a-number-is-power-of-another-number/
public class PowerOf {
    static double logbase(int y, int x) {
        return Math.log(y) / Math.log(x);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf(1, 1));
        System.out.println(isPowerOf(1, 10)); // 10^0 = 1
        System.out.println(isPowerOf(216, 6)); // 6^3 = 216
        System.out.println(isPowerOf(256, 2)); // 1^8 = 256
        System.out.println(isPowerOf(255, 6));

        System.out.println();

        System.out.println(isPowerOfIterative(1, 1));
        System.out.println(isPowerOfIterative(1, 10)); // 10^0 = 1
        System.out.println(isPowerOfIterative(216, 6)); // 6^3 = 216
        System.out.println(isPowerOfIterative(256, 2)); // 1^8 = 256
        System.out.println(isPowerOfIterative(255, 6));
    }

    /**
     * This is unreliable due to rounding errors
     */
    private static boolean isPowerOf(int y, int x) {
        double result = logbase(y, x);
        return DoubleMath.isMathematicalInteger(result);
    }

    private static boolean isPowerOfIterative(int y, int x) {
        if (x == 1) {
            return y == 1;
        }
        while (y > 1) {
            if (y % x != 0) return false;
            y = y / x;
        }
        return true;
    }
}