package heap;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKthSmallestLargest {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{3, 4, 5, 1, 6, 2, 8};
        System.out.println(findKthSmallest(Arrays.asList(list), 2));
        System.out.println(findKthLargest(Arrays.asList(list), 2));
    }

    static int findKthSmallest(List<Integer> list, int k) {
        Preconditions.checkArgument(k <= list.size());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // max-heap
        pq.addAll(list.subList(0, k));
        for (int i = k; i < list.size(); i++) {
            if (pq.peek() > list.get(i)) {
                pq.poll();
                pq.add(list.get(i));
            }
        }
        return pq.peek();
    }

    static int findKthLargest(List<Integer> list, int k) {
        Preconditions.checkArgument(k <= list.size());
        PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k)); // min-heap
        for (int i = k; i < list.size(); i++) {
            if (pq.peek() < list.get(i)) {
                pq.poll();
                pq.add(list.get(i));
            }
        }
        return pq.peek();
    }
}
