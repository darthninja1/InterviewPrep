package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
// https://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
public class SpiralMatrix {

    public static void main(String[] args) {
        //@formatter:off
        int[][] matrix = {{1, 2, 3, 4, 5},
                          {6, 7, 8, 9, 10},
                          {11, 12, 13, 14, 15},
                          {16, 17, 18, 19, 20}};
        //@formatter:on
        System.out.println(spiral(matrix));
        int n = 1;
        int[][] m2 = new int[10][10];
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                m2[i][j] = n++;
            }
        }
        System.out.println(spiral(m2));
    }

    /*
        L               R
     U  1   2   3   4   5
        6   7   8   9  10
       11  12  13  14  15
     D 16  17  18  19  20
     */
    private static List<Integer> spiral(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}