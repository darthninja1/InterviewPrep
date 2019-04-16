package number;

import static number.PowerOf.logbase;

public class PowerOfFour {
    public static void main(String[] args) {
        powerOf4(64);
        powerOf4(100);

        powerOf4Modulo(64);
        powerOf4Modulo(100);
    }

    private static double logbase4(int num) {
        return logbase(num, 4);
    }

    private static void powerOf4(int num) {
        double result = logbase4(num);
        System.out.println(num + " is" + (result == Math.rint(result) ? " " : " not ") + "a power of 4");
    }

    private static void powerOf4Modulo(int num) {
        int temp = num;
        while (temp > 1) {
            if (temp % 4 != 0) {
                System.out.println(num + " is not a power of 4");
                return;
            }
            temp = temp >> 2;
        }
        System.out.println(num + " is a power of 4");
    }
}
