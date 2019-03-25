package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://en.wikipedia.org/wiki/Heapsort
public class HeapSort {

    public static void main(String[] args) {
        new HeapSort().sort(Arrays.asList(1, 3, 36, 2, 19, 25, 100, 17, 7));
        new HeapSort().sort(Arrays.asList(100, 90, 80, 70, 60, 50, 40, 30, 20, 10));
    }

    private void sort(List<Integer> nums) {
        System.out.println("Before - " + nums);
        maxHeapify(nums);
        for (int i = nums.size() - 1; i >= 0; i--) {
            // Move current root to end
            Collections.swap(nums, 0, i);
            siftDown(nums, 0, i);
        }
        System.out.println("After - " + nums);
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    private void maxHeapify(List<Integer> nums) {
        int n = nums.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, n);
        }
    }

    private void siftDown(List<Integer> nums, int i, int end) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int largest = i;
        if (left < end && nums.get(left) > nums.get(largest)) {
            largest = left;
        }
        if (right < end && nums.get(right) > nums.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            Collections.swap(nums, i, largest);
            siftDown(nums, largest, end);
        }
    }
}