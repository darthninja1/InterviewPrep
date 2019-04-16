package array;

/*
Return the length of the cycle ( inputs are integer array and start index)
Integer array contains only positive integers. We need to consider array values as index pointers.
Start from the start index traverse until reaching start index then return length of cycle.
If we can't reach start index then return -1.
 */
public class DetectLoop {
    public static void main(String[] args) {
        System.out.println(detectLoop(new int[]{1, 2, 3, 4, 5, 2}, 2));
        System.out.println(detectLoop(new int[]{1, 2, 4}, 0));
    }

    private static int detectLoop(int[] arr, int start) {
        int count = 0;
        for (int i = start; count < arr.length && arr[i] < arr.length; ) {
            int next = arr[i];
            // Have we visited it before and it is the starting index
            if (next < 0 && i == start) return count;
            // Mark entry as visited by negating it
            arr[i] = -next;
            i = next;
            count++;
        }
        return -1;
    }
}