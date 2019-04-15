package array;

/*
    Given I and J generate the value in Pascal triangle, find the element at ith row and jth column,
    https://www.geeksforgeeks.org/pascal-triangle/
 */
public class PascalTriangle {
    /*
            1
            1 1
            1 2 1
            1 3 3 1
            1 4 6 4 1
            1 5 10 10 5 1
            1 6 15 20 15 6 1
     */
    public static void main(String[] args) {
        int[][] pascalTriangle = generate(10);
        System.out.println(pascalTriangle[5][3]);
    }

    private static int[][] generate(int n) {
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }

        print(arr);
        return arr;
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}