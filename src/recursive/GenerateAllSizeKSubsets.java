package recursive;

// https://www.geeksforgeeks.org/print-subsets-given-size-set/
// https://algorithms.tutorialhorizon.com/print-all-combinations-of-subset-of-size-k-from-given-array/
public class GenerateAllSizeKSubsets {
    public static void main(String[] args) {
        allSubsetsRecursive(new int[]{1, 2, 3}, new boolean[3], 0, 0, 2);
        allSubsetsRecursive(new int[]{10, 20, 30, 40, 50}, new boolean[5], 0, 0, 3);
    }

    private static void allSubsetsRecursive(int[] numbers, boolean[] include, int index, int currLen, int k) {
        if (currLen == k) {
            System.out.print("{ ");
            for (int i = 0; i < include.length; i++) {
                if (include[i]) {
                    System.out.print(numbers[i] + " ");
                }
            }
            System.out.println("}");
        } else if (index == numbers.length) {
            return;
        } else {
            include[index] = true;
            allSubsetsRecursive(numbers, include, index + 1, currLen + 1, k);
            include[index] = false;
            allSubsetsRecursive(numbers, include, index + 1, currLen, k);
        }
    }
}
