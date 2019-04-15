package recursive;

// https://www.dailycodingproblem.com/blog/staircase-problem/
public class Staircase {

    public static void main(String[] args) {
        System.out.println(numWays(1));
        System.out.println(numWays(2));
        System.out.println(numWays(3));
        System.out.println(numWays(4));
        System.out.println(numWays(10));

        System.out.println();

        System.out.println(numWays4(1));
        System.out.println(numWays4(2));
        System.out.println(numWays4(3));
        System.out.println(numWays4(4));
        System.out.println(numWays4(10));
    }

    // can take 1, 2 or 3 steps
    private static int numWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1 || n == 2) return n;
        return numWays(n - 1) + numWays(n - 2) + numWays(n - 3);
    }

    // can take 1, 2, 3 or 4 steps
    private static int numWays4(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1 || n == 2) return n;
        if (n == 3) return numWays4(n - 1) + numWays4(n - 2) + numWays4(n - 3);
        return numWays4(n - 1) + numWays4(n - 2) + numWays4(n - 3) + numWays4(n - 4);
    }
}