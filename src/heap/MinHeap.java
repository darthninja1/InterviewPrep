package heap;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

import static heap.MaxHeap.getLeftChild;
import static heap.MaxHeap.getParent;
import static heap.MaxHeap.getRightChild;

public class MinHeap {

    private final List<Integer> nums;

    public MinHeap(List<Integer> list) {
        this.nums = list;
        minHeapify(nums);
    }

    public static void main(String[] args) {
        List<Integer> nums = Lists.newArrayList(64, 13, 36, 2, 19, 25, 100, 17, 7);
        MinHeap heap = new MinHeap(nums);
        System.out.println("Min: " + heap.getMin());
        System.out.println(heap.getHeapList());
        System.out.println("Inserting 1");
        heap.insert(1);
        System.out.println("Min: " + heap.getMin());
        System.out.println(heap.getHeapList());
        System.out.println("Removing min... ");
        heap.removeMin();
        System.out.println(heap.getHeapList());
        System.out.println("Inserting 33... ");
        heap.insert(33);
        System.out.println(heap.getHeapList());
        System.out.println("Removing min... ");
        heap.removeMin();
        System.out.println(heap.getHeapList());
    }

    public static void minHeapify(List<Integer> nums) {
        int n = nums.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, n);
        }
    }

    public static void siftDown(List<Integer> nums, int i, int end) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int smallest = i;
        if (left < end && nums.get(left) < nums.get(smallest)) {
            smallest = left;
        }
        if (right < end && nums.get(right) < nums.get(smallest)) {
            smallest = right;
        }
        if (smallest != i) {
            Collections.swap(nums, i, smallest);
            siftDown(nums, smallest, end);
        }
    }

    // peek
    int getMin() {
        return nums.get(0);
    }

    List<Integer> getHeapList() {
        return nums;
    }

    int removeMin() {
        int min = nums.get(0);
        int last = nums.remove(nums.size() - 1);
        // Copy last element to index 0 and call heapify
        nums.set(0, last);
        minHeapify(nums);
        return min;
    }

    void insert(int n) {
        nums.add(n);
        int index = nums.size() - 1;
        int parentIndex = getParent(index);
        while (nums.get(index) < nums.get(parentIndex)) {
            Collections.swap(nums, index, parentIndex);
            index = parentIndex;
            parentIndex = getParent(index);
        }
    }
}
