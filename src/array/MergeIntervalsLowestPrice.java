package array;

import java.util.Arrays;

// Find non-overlapping intervals with lowest price
public class MergeIntervalsLowestPrice {
    public static void main(String[] args) {
        // Each tuple - start time, end time, price
        int[][] intervals = new int[][]{{1, 5, 20}, {3, 7, 15}, {8, 10, 8}};
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(merge(intervals)));

        int[][] intervals2 = new int[][]{{1, 5, 20}, {3, 7, 15}, {7, 8, 2}, {8, 10, 8}};
        Arrays.sort(intervals2, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(merge(intervals2)));
    }

    private static int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][3];
        int current = 0;
        int[] currentInterval = intervals[current];
        int resultIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[current][1] >= intervals[i][0]) {
                if (intervals[current][2] > intervals[i][2]) {
                    result[resultIndex][0] = currentInterval[0];
                    result[resultIndex][1] = intervals[i][0] - 1;
                    result[resultIndex++][2] = currentInterval[2];
                } else {
                    result[resultIndex][0] = currentInterval[0];
                    result[resultIndex][1] = currentInterval[1];
                    result[resultIndex++][2] = currentInterval[2];
                    intervals[i][0] = currentInterval[1] + 1;
                }
            } else {
                result[resultIndex][0] = currentInterval[0];
                result[resultIndex][1] = currentInterval[1];
                result[resultIndex++][2] = currentInterval[2];
            }
            current = i;
            currentInterval = intervals[current];
        }
        result[resultIndex][0] = currentInterval[0];
        result[resultIndex][1] = currentInterval[1];
        result[resultIndex][2] = currentInterval[2];
        return result;
    }
}