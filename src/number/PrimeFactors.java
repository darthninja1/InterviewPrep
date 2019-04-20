package number;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static void main(String[] args) {
        System.out.println(isPrime(12));
        System.out.println(isPrime(121));
        System.out.println(isPrime(13));
        System.out.println(isPrime(151));

        System.out.println(primeFactors(12));
        System.out.println(primeFactors(121));
        System.out.println(primeFactors(13));
        System.out.println(primeFactors(151));
        System.out.println(primeFactors(96));
    }

    private static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n != 1) {
            while (n % 2 == 0) {
                n = n / 2;
                factors.add(2);
            }
            for (int i = 3; i <= n; i += 2) {
                if (isPrime(i)) {
                    while (n % i == 0) {
                        n = n / i;
                        factors.add(i);
                    }
                }
            }
        }
        return factors;
    }

    private static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n <= 1 || n % 2 == 0) return false;
        for (int i = 3; i < Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
