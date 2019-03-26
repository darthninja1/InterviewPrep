package number;

// https://leetcode.com/problems/powx-n
public class PowerOfX {
    public static void main(String[] args) {
        System.out.println(powerX(2, -10));
        System.out.println(powerX(2, 10));
        System.out.println(powerX(2, 9));
    }

    private static double powerX(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        double half = powerX(x, n / 2);
        return (n % 2 == 0) ? half * half : x * half * half;
    }
}
