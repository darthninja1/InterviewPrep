package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class QueueWithStacks {
    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> tempStack = new LinkedList<>();
    private int top = -1;

    public static void main(String[] args) {
        QueueWithStacks queue = new QueueWithStacks();
        queue.push(5);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        IntStream.range(0, 10).forEach(i -> queue.push(i));
        IntStream.range(0, 10).forEach(i -> System.out.println(queue.pop()));

        // queue is empty
        System.out.println(queue.empty());
    }

    private void push(int n) {
        if (stack.isEmpty()) {
            this.top = n;
        }
        stack.push(n);
    }

    private int peek() {
        if (stack.isEmpty()) return -1;
        return top;
    }

    private boolean empty() {
        return stack.isEmpty();
    }

    private int pop() {
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        int n = tempStack.pop();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return n;

    }
}
