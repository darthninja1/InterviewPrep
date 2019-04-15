package array;

/*
 * Given an unsorted array of size N of positive integers. One number 'A' from
 * set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find
 * these two numbers.
 * For example, if the input array of size 3 is {1,3,3}, then the output should
 * be "3 2"(3 is repeated, 2 is missing).
 */
// https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
class MissingAndDupeNumbers {
    public static void main(String[] args) {
        System.out.println(getResult(new int[]{2, 2}).equals("2 1"));
        System.out.println(getResult(new int[]{3, 2, 1, 1}).equals("1 4"));
        System.out.println(getResult(new int[]{2, 1, 5, 4, 4}).equals("4 3"));
    }

    public static String getResult(int[] arr) {
        int len = arr.length;
        boolean[] presence = new boolean[len];
        int dupe = -1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (!presence[arr[i] - 1]) {
                sum += arr[i];
                presence[arr[i] - 1] = true;
            } else {
                dupe = arr[i];
            }
        }
        return String.valueOf(dupe) + " " + (len * (len + 1) / 2 - sum);
    }
}
