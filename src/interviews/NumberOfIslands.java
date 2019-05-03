package interviews;

import java.util.Arrays;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1}
        };
        System.out.println(islandCount(matrix));
        System.out.println(islandCount(new int[4][5]));
        int[][] matrix2 = new int[5][6];
        for (int i = 0; i < matrix2.length; i++) {
            Arrays.fill(matrix2[i], 1);
        }
        System.out.println(islandCount(matrix2));
    }

    private static int islandCount(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != 1) {
            return;
        }
        matrix[i][j] = 0;
        dfs(matrix, i, j + 1);
        dfs(matrix, i, j - 1);
        dfs(matrix, i + 1, j);
        dfs(matrix, i - 1, j);
    }
}
