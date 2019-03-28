package bits;

// http://www.ardendertat.com/2011/09/27/programming-interview-questions-4-find-missing-element/
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("Missing number: " + find(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 2, 1}));
        System.out.println("Missing number: " + find(new int[]{1, 12, 33, 40, 5}, new int[]{33, 40, 12, 1}));
    }

    private static int find(int[] arr, int[] shuffle) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        for (int i = 0; i < shuffle.length; i++) {
            xor ^= shuffle[i];
        }
        return xor;
    }
}
