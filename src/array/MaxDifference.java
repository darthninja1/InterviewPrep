package array;

// https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
public class MaxDifference {
    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
        System.out.println(maxDiff(new int[]{1, 2, 90, 10, 110}));

    }

    private static int maxDiff(int[] arr) {
        int diff = Integer.MIN_VALUE;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min > diff) {
                diff = arr[i] - min;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return diff;
    }
}
