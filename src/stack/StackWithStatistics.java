package stack;

import java.util.*;

public class StackWithStatistics {
    private static final TreeMap<Integer, Integer> numToFreqMap = new TreeMap<>();
    private static final TreeMap<Integer, TreeSet<Integer>> freqToNumMap = new TreeMap<>(Comparator.reverseOrder());
    private static Deque<StackElement> stack = new ArrayDeque<>();

    public static void main(String[] args) {
        push(1);
        System.out.println(getMin() + " " + getMax() + " " + getAvg() + " " + getMode());
        push(2);
        System.out.println(getMin() + " " + getMax() + " " + getAvg() + " " + getMode());
        push(3);
        System.out.println(getMin() + " " + getMax() + " " + getAvg() + " " + getMode());
        push(1);
        System.out.println(getMin() + " " + getMax() + " " + getAvg() + " " + getMode());

        System.out.println("Popping... " + pop());
        System.out.println(getMin() + " " + getMax() + " " + getAvg() + " " + getMode());
        System.out.println("Popping... " + pop());
        System.out.println(getMin() + " " + getMax() + " " + getAvg() + " " + getMode());
        System.out.println("Popping... " + pop());
        System.out.println(getMin() + " " + getMax() + " " + getAvg() + " " + getMode());
    }

    private static int getMin() {
        assert stack.peek() != null;
        return stack.peek().min;
    }

    private static int getMax() {
        assert stack.peek() != null;
        return stack.peek().max;
    }

    private static double getAvg() {
        assert stack.peek() != null;
        return stack.peek().totalSum * 1.0 / stack.size();
    }

    private static Map.Entry<Integer, TreeSet<Integer>> getMode() {
        return freqToNumMap.firstEntry();
    }

    private static int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("empty");
        }
        StackElement top = stack.pop();
        int value = top.value;
        int freq = numToFreqMap.get(value);
        if (freq == 1) {
            numToFreqMap.remove(value);
        } else {
            numToFreqMap.put(value, freq - 1);
            // There is more than 1 entry for "value"
            // insert updated frequency
            freqToNumMap.computeIfPresent(freq - 1, (f, set) -> {
                set.add(value);
                return set;
            });
        }

        // Remove "value" from old freq map entry
        // If its the only value for the freq, then delete that entry
        TreeSet<Integer> list = freqToNumMap.get(freq);
        if (list.size() > 1) {
            list.remove(value);
            freqToNumMap.put(freq, list);
        } else {
            freqToNumMap.remove(freq);
        }
        return top.value;
    }

    private static void push(int value) {
        StackElement top = stack.peek();
        if (top == null) {
            stack.push(new StackElement(value, value, value, value));
            numToFreqMap.put(value, 1);
            TreeSet<Integer> set = new TreeSet<>();
            set.add(value);
            freqToNumMap.put(1, set);
        } else {
            int min = top.min;
            int max = top.max;
            if (value > top.max) {
                max = value;
            }
            if (value < top.min) {
                min = value;
            }
            stack.push(new StackElement(value, min, max, top.totalSum + value));
            Integer freq = numToFreqMap.get(value);
            numToFreqMap.put(value, freq == null ? 1 : freq + 1);
            if (freq != null) {
                freqToNumMap.computeIfPresent(freq, (f, s) -> {
                    s.remove(value);
                    return (s.size() > 1) ? s : null;
                });
                freq++;
            } else {
                freq = 1;
            }
            TreeSet<Integer> set = freqToNumMap.computeIfAbsent(freq, f -> new TreeSet<>());
            set.add(value);
            freqToNumMap.put(freq, set);
        }
    }

    private static class StackElement {
        int value;
        int min;
        int max;
        int totalSum;

        StackElement(int value, int min, int max, int sum) {
            this.value = value;
            this.min = min;
            this.max = max;
            this.totalSum = sum;
        }
    }
}
