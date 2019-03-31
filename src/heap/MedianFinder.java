package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {

    private PriorityQueue<Integer> largerNumbers = new PriorityQueue<>();
    private PriorityQueue<Integer> smallerNumbers = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        System.out.println(mf.findMedian());
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

    private void addNum(int num) {
        // If left is empty or head of maxheap> num
        if (smallerNumbers.isEmpty() || smallerNumbers.peek() >= num) {
            smallerNumbers.offer(num);
        } else {
            largerNumbers.offer(num);
        }
        if (smallerNumbers.size() > 1 + largerNumbers.size()) {
            largerNumbers.offer(smallerNumbers.poll());
        }
        if (largerNumbers.size() > 1 + smallerNumbers.size()) {
            smallerNumbers.offer(largerNumbers.poll());
        }
    }

    private double findMedian() {
        int largeHead = largerNumbers.size();
        int smallHead = smallerNumbers.size();

        if (largeHead == 0 && smallHead == 0) {
            return 0;
        } else if (largeHead > smallHead)
            return largerNumbers.peek();
        else {
            return (largerNumbers.peek() - smallerNumbers.peek()) / 2.0;
        }
    }
}
