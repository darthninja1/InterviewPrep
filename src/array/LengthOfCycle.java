package array;/* Problem Name is &&& Count Length Of Cycle &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement countLengthOfCycle() correctly.
 * 4) If time permits, try to improve your implementation.
 */
public class LengthOfCycle {
    /**
     * countLengthOfCycle(arr, startIndex)
     * <p>
     * You are given an integer array of size N.
     * Every element of the array is greater than or equal to 0.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     * <p>
     * Examples:
     * countLengthOfCycle([1, 0], 0) == 2
     * countLengthOfCycle([1, 2, 0], 0) == 3
     */
    public static int countLengthOfCycle(int[] arr, int startIndex) {
        // base case
        if (arr == null || arr.length == 0 || arr.length == 1 || startIndex >= arr.length) {
            return -1;
        }
        boolean[] visited = new boolean[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; ) {
            int nextIndex = arr[i];
            count++;
            if (visited[nextIndex]) {
                return count - nextIndex;
            }
            visited[i] = true;
            i = nextIndex;
        }
        return -1;
    }

    /**
     * boolean doTestsPass()
     * Returns true if all the tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // TODO: implement some tests, please
        // we've included a trivial boilerplate

        boolean testsPassed = true;

        testsPassed &= countLengthOfCycle(null, 0) == -1;
        testsPassed &= countLengthOfCycle(new int[]{}, 0) == -1;
        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 100) == -1;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0}, 10) == -1;
        // 0 -> 1 -> 2 -> 3 -> 4
        // 1 -> 2 -> 3 -> 4 -> 0
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4, 0}, 0) == 5;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0}, 0) == 9;
        // 0 -> 1 -> 2 -> 3 -> 4
        // 1 -> 4 -> 3 -> 0 -> 2
        testsPassed &= countLengthOfCycle(new int[]{1, 4, 3, 0, 2}, 0) == 5;
        testsPassed &= countLengthOfCycle(new int[]{1, 4, 3, 2, 2}, 0) == 3;
        testsPassed &= countLengthOfCycle(new int[]{1, 4, 3, 2, 3}, 0) == 2;
        // 0 -> 1 -> 2 -> 3 -> 4
        // 1 -> 4 -> 3 -> 2 -> 2
        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;

        if (testsPassed) {
            System.out.println("Test passed.");
            return true;
        } else {
            System.out.println("Test failed.");
            return false;
        }
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}


