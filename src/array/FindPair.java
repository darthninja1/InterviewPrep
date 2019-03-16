package array;

import java.util.HashMap;

public class FindPair {
    public static void main(String[] args) {
        findPair(new int[]{3, 4, 5, 1, 6, 2, 8}, 11);
        findPair(new int[]{3, 4, 5, 1, 6, 2, 8}, 100);
    }

    private static void findPair(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                found = true;
                System.out.println("Found sum: " + arr[i] + " + " + arr[map.get(sum - arr[i])] + " = " + sum);
            }
            map.put(arr[i], i);
        }
        if (!found) System.out.println("No pairs found that sum up to " + sum);
    }

}
