package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-subarray/
public class ZeroSumSubarray {
    public static void main(String[] args) {
        System.out.println(containsZeroSumSubarry(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(containsZeroSumSubarry(new int[]{-2, -1, -3, -4, -1, -2, 1, -5, 4}));
        System.out.println(containsZeroSumSubarry(new int[]{-2, 1, -3, 0, -4, -1}));
        System.out.println(containsZeroSumSubarry(new int[]{-3, 2, 3, 1, 6}));
        System.out.println(containsZeroSumSubarry(new int[]{1, 2, -5, 1, 2, -1}));


        System.out.println(Arrays.toString(zeroSumSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})));
        System.out.println(Arrays.toString(zeroSumSubarray(new int[]{-2, -1, -3, -4, -1, -2, 1, -5, 4})));
        System.out.println(Arrays.toString(zeroSumSubarray(new int[]{-2, 1, -3, 0, -4, -1})));
        System.out.println(Arrays.toString(zeroSumSubarray(new int[]{-3, 2, 3, 1, 6})));
        System.out.println(Arrays.toString(zeroSumSubarray(new int[]{1, 2, -5, 1, 2, -1})));
        System.out.println(Arrays.toString(zeroSumSubarray(new int[]{3, 4, -7, 3, 1, 3, 1, -4, -2, -2})));
    }

    private static boolean containsZeroSumSubarry(int[] arr) {
        Set<Integer> sumMap = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || sumMap.contains(sum)) {
                return true;
            }
            sumMap.add(sum);
        }
        return false;
    }

    private static int[] zeroSumSubarray(int[] arr) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                return Arrays.copyOfRange(arr, 0, i + 1);
            }
            if (arr[i] == 0) {
                return new int[]{0};
            }
            if (sumMap.containsKey(sum)) {
                return Arrays.copyOfRange(arr, sumMap.get(sum) + 1, i + 1);
            }
            sumMap.put(sum, i);
        }
        return null;
    }
}
