package array;

// http://www.ardendertat.com/2011/09/20/programming-interview-questions-2-matrix-region-sum/
// https://www.geeksforgeeks.org/submatrix-sum-queries/
public class SubMatrixSum {
    int[][] matrix;
    int[][] preProcessedSum;

    public SubMatrixSum(int[][] mat) {
        this.matrix = mat;
        preprocess();
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}};
        SubMatrixSum m = new SubMatrixSum(mat);
        m.print(m.matrix);
        m.print(m.preProcessedSum);
        System.out.println("\nSum: " + m.sum(1, 1, 2, 3));
        System.out.println("\nSum: " + m.sum(1, 2, 3, 3));
    }

    private void preprocess() {
        preProcessedSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            preProcessedSum[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preProcessedSum[i][j] = matrix[i][j] + preProcessedSum[i - 1][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                preProcessedSum[i][j] += preProcessedSum[i][j - 1];
            }
        }
    }

    private int sum(int ti, int tj, int bi, int bj) {
        return preProcessedSum[bi][bj] + preProcessedSum[ti-1][tj-1]
                - preProcessedSum[ti-1][bj] - preProcessedSum[bi][tj-1];

    }

    private void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}