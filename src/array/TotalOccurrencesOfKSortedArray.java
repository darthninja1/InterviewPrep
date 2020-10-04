package array;

// https://www.youtube.com/watch?v=RlXtTF34nnE
// https://leetcode.com/discuss/interview-question/124724/
public class TotalOccurrencesOfKSortedArray {

    public static void main(String[] args) {
        System.out.println(totalCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 1));
        System.out.println(totalCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));
        System.out.println(totalCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 7));
        System.out.println(totalCount(new int[]{1, 1, 1, 4, 5, 6, 7}, 1));
        System.out.println(totalCount(new int[]{1, 2, 2, 2, 2, 6, 7}, 2));
        System.out.println(totalCount(new int[]{1, 2, 2, 2, 2, 6, 7}, 8));
        System.out.println(totalCount(new int[]{1, 2, 2, 2, 7, 7, 7}, 7));
    }

    private static int totalCount(int[] array, int k) {
        int firstIndex = search(array, k, true);
        int lastIndex = search(array, k, false);
        if (firstIndex == -1 || lastIndex == -1) {
            return 0;
        } else {
            return lastIndex - firstIndex + 1;
        }
    }

    private static int search(final int[] array, int num, boolean wantFirst /* or want last */) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            // Changed from (start+end)/2 to handle overflow due to integer addition
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (array[mid] > num) {
                endIndex = mid - 1;
            } else if (array[mid] < num) {
                startIndex = mid + 1;
            } else {
                if (wantFirst) {
                    if (mid > 0 && array[mid - 1] == array[mid]) {
                        endIndex = mid - 1;
                        continue;
                    }
                } else {
                    if (mid < array.length - 1 && array[mid + 1] == array[mid]) {
                        startIndex = mid + 1;
                        continue;
                    }
                }
                return mid;
            }
        }
        return -1;
    }
}
