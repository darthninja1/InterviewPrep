package array;

// https://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
public class ConsecutiveIntegers {
    public static void main(String[] args) {
        System.out.println(isConsecutive(new int[]{3, 4, 5, 1, 2}));
        System.out.println(isConsecutive(new int[]{3, 4, -5, 1, 2}));
        System.out.println(isConsecutive(new int[]{3, 4, 2, 1, 2}));
        System.out.println(isConsecutive(new int[]{3, 7, 5, 1, 2}));
        System.out.println(isConsecutive(new int[]{3, 7, 5, 1, -2}));
        System.out.println(isConsecutive(new int[]{38, 37, 36, 35, 34}));
        System.out.println(isConsecutive(new int[]{-38, -37, -36, -35, -34}));
    }

    private static boolean isConsecutive(int[] arr) {
        // find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        if (max - min + 1 != arr.length) {
            return false;
        }
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!visited[arr[i] - min]) {
                visited[arr[i] - min] = true;
            } else { // duplicate
                return false;
            }
        }
        return true;
    }
}
