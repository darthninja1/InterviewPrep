package array;

import java.util.Arrays;

// https://leetcode.com/problems/island-perimeter
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(islandPerimeter(matrix));
        System.out.println(islandPerimeter(new int[4][5]));
        System.out.println(islandPerimeter(new int[][]{{1}, {0}}));
        System.out.println(islandPerimeter(new int[][]{{1, 0}}));
        System.out.println(islandPerimeter(new int[][]{{1}}));

        int[][] matrix2 = new int[5][6];
        for (int i = 0; i < matrix2.length; i++) {
            Arrays.fill(matrix2[i], 1);
        }
        System.out.println(islandPerimeter(matrix2));
    }

    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // top edge
                    if (i == 0) {
//                        System.out.println("top edge");
                        perimeter++;
                    }
                    // bottom edge
                    if (i == grid.length - 1) {
//                        System.out.println("bottom edge");
                        perimeter++;
                    }
                    // left edge
                    if (j == 0) {
//                        System.out.println("left edge");
                        perimeter++;
                    }
                    if (j == grid[0].length - 1) {
//                        System.out.println("right edge");
                        perimeter++;
                    }
                    // left
                    if (i > 0 && grid[i - 1][j] == 0) {
//                        System.out.println("left");
                        perimeter++;
                    }
                    // right
                    if (i < grid.length - 1 && grid[i + 1][j] == 0) {
//                        System.out.println("right");
                        perimeter++;
                    }
                    // above
                    if (j > 0 && grid[i][j - 1] == 0) {
//                        System.out.println("above");
                        perimeter++;
                    }
                    // below
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
//                        System.out.println("below");
                        perimeter++;
                    }
                }
//                System.out.println("i: " + i + ", j= " + j + " -> " + perimeter);
            }
        }
        return perimeter;
    }
}
