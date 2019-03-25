package array;

// https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
public class CommonElements {
    public static void main(String[] args) {
        System.out.println(common(
                new int[]{2, 4, 13, 18, 29, 40, 40, 55, 63, 78},
                new int[]{13, 23, 33, 40, 40, 60, 89},
                new int[]{3, 5, 7, 9, 11, 13, 14, 18, 23, 35, 40, 40, 45, 60, 89}));
        System.out.println(common(
                new int[]{2, 4, 18, 29, 40, 55, 63, 78},
                new int[]{13, 23, 33, 40, 40, 89},
                new int[]{3, 11, 13, 14, 18, 23, 35, 40, 40, 45, 60, 89}));
        System.out.println(common(
                new int[]{2, 4, 18, 29, 40, 55, 63, 78},
                new int[]{13, 23, 33, 40, 40, 89},
                new int[]{3, 60, 89}));
    }

    private static String common(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        StringBuilder sb = new StringBuilder("Result: ");
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                sb.append(arr1[i]).append(" ");
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j] && arr1[i] < arr3[k]) {
                i++;
            } else if (arr1[i] > arr2[j] && arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return sb.toString();
    }
}