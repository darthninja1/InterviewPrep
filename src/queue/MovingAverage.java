package queue;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/program-find-simple-moving-average/
// https://www.programcreek.com/2014/05/leetcode-moving-average-from-data-stream-java/
public class MovingAverage {
    private int windowSize;
    private double windowSum; // use double to avoid integer division
    private Queue<Integer> queue;

    private MovingAverage(int windowSize) {
        this.windowSize = windowSize;
        queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        MovingAverage mAvg = new MovingAverage(3);
        System.out.println(mAvg.next(1));
        System.out.println(mAvg.next(10));
        System.out.println(mAvg.next(3));
        System.out.println(mAvg.next(5));
    }

    private double next(int n) {
        if (queue.size() == windowSize) {
            int removed = queue.remove();
            windowSum -= removed;
        }
        queue.add(n);
        windowSum += n;
        return windowSum / queue.size();
    }
}
