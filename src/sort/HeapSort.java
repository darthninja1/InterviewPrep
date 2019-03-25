package sort;

import heap.MaxHeap;

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
        MaxHeap.maxHeapify(nums);
        for (int i = nums.size() - 1; i >= 0; i--) {
            // Move current root to end
            Collections.swap(nums, 0, i);
            MaxHeap.siftDown(nums, 0, i);
        }
        System.out.println("After - " + nums);
    }
}