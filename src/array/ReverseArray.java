package array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5})));
    }

    private static int[] reverse(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (endIndex > startIndex) {
            int temp = arr[endIndex];
            arr[endIndex--] = arr[startIndex];
            arr[startIndex++] = temp;
        }
        return arr;
    }
}
