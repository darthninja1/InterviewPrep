package array;

import java.util.Arrays;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(merge(intervals)));
        int[][] intervals2 = new int[][]{{8, 10}, {1, 3}, {2, 6}, {9, 11}, {15, 18}};
        Arrays.sort(intervals2, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(merge(intervals2)));
    }

    private static int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        int current = 0;
        int[] currentInterval = intervals[current];
        int resultIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[current][1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(intervals[current][1], intervals[i][1]);
            } else {
                result[resultIndex][0] = currentInterval[0];
                result[resultIndex++][1] = currentInterval[1];
                current = i;
                currentInterval = intervals[current];
            }
        }
        result[resultIndex][0] = currentInterval[0];
        result[resultIndex][1] = currentInterval[1];
        return result;
    }
}