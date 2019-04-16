package number;

// https://leetcode.com/problems/ugly-number/
// https://leetcode.com/problems/ugly-number-ii/
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(uglyNumber(10));
        System.out.println(isUgly(12));
        System.out.println(isUgly(13));
    }

    private static boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return true;
    }

    private static int uglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int next2 = 2 * arr[i2];
            int next3 = 3 * arr[i3];
            int next5 = 5 * arr[i5];
            int nextLowest = Math.min(Math.min(next2, next3), next5);
            if (next2 == nextLowest) {
                i2++;
                arr[i] = next2;
            }
            if (next3 == nextLowest) {
                i3++;
                arr[i] = next3;
            }
            if (next5 == nextLowest) {
                i5++;
                arr[i] = next5;
            }
        }
        return arr[n - 1];
    }
}