package array;

/*
    Given an n x n grid, count squares in it. Examples :
    Input: n = 2 Output: 5 (4 squares of 1 unit + 1 square of 2 units)
    Input: n = 3 Output: 14 (9 squares of 1 unit + 4 square of 2 units + 1 square of 1 unit)
 */
public class CountSquares {
    /*
        1  1
        1  1

        1  1  1
        1  1  1
        1  1  1

        1  1  1  1
        1  1  1  1
        1  1  1  1
        1  1  1  1

        1  1  1  1  1
        1  1  1  1  1
        1  1  1  1  1
        1  1  1  1  1
        1  1  1  1  1
     */
    public static void main(String[] args) {
        System.out.println(squareCount(4));
    }

    private static int squareCount(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // i = 2 => 4 + 1
            // i = 3 => 9 + 5
            // i = 4 => 16 + 14
            arr[i] = n * n + arr[i - 1];
        }
        return arr[n];
    }
}