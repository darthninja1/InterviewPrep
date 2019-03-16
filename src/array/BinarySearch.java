package array;


public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(search(array, 5));
        System.out.println(search(array, 9));
        System.out.println(search(array, 1));
    }

    static int search(final int[] array, int num) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            int mid = (endIndex + startIndex) / 2;
            if (array[mid] > num) {
                endIndex = mid - 1;
            } else if (array[mid] < num) {
                startIndex = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}