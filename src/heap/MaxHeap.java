package heap;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class MaxHeap {

    private final List<Integer> nums;

    public MaxHeap(List<Integer> list) {
        this.nums = list;
        maxHeapify(nums);
    }

    public static void main(String[] args) {
        List<Integer> nums = Lists.newArrayList(1, 3, 36, 2, 19, 25, 100, 17, 7);
        MaxHeap heap = new MaxHeap(nums);
        System.out.println("Max: " + heap.getMax());
        System.out.println(heap.getHeapList());
        System.out.println("Inserting 120");
        heap.insert(120);
        System.out.println("Max: " + heap.getMax());
        System.out.println(heap.getHeapList());
        System.out.println("Removing max... ");
        heap.removeMax();
        System.out.println(heap.getHeapList());
        System.out.println("Inserting 33... ");
        heap.insert(33);
        System.out.println(heap.getHeapList());
    }

    private static int getParent(int index) {
        return index / 2;
    }

    private static int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private static int getRightChild(int index) {
        return 2 * index + 2;
    }

    public static void maxHeapify(List<Integer> nums) {
        int n = nums.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, n);
        }
    }

    public static void siftDown(List<Integer> nums, int i, int end) {
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

    // peek
    int getMax() {
        return nums.get(0);
    }

    List<Integer> getHeapList() {
        return nums;
    }

    int removeMax() {
        int max = nums.get(0);
        int last = nums.remove(nums.size() - 1);
        // Copy last element to index 0 and call heapify
        nums.set(0, last);
        maxHeapify(nums);
        return max;
    }

    void insert(int n) {
        nums.add(n);
        int index = nums.size() - 1;
        int parentIndex = getParent(index);
        while (nums.get(index) > nums.get(parentIndex)) {
            Collections.swap(nums, index, parentIndex);
            index = parentIndex;
            parentIndex = getParent(index);
        }
    }
}
