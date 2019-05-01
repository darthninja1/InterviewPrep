package stack;

import java.util.Arrays;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
public class SortWithTwoStacks {
    public static void main(String[] args) {
        System.out.println(sort(new LinkedList<>(Arrays.asList(5, 14, 30, 2, 1))));
        System.out.println(sortRecursive(new LinkedList<>(Arrays.asList(5, 14, 30, 2, 1))));

        System.out.println(sort(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.println(sortRecursive(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5))));
    }

    private static LinkedList<Integer> sort(LinkedList<Integer> stack1) {
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            while (!stack2.isEmpty() && stack2.peek() > temp) {
                stack1.push(stack2.pop());
            }
            stack2.push(temp);
        }
        return stack2;
    }

    private static LinkedList<Integer> sortRecursive(LinkedList<Integer> stack1) {
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (!stack1.isEmpty()) {
            moveToRightSlot(stack2, stack1.pop());
        }
        return stack2;
    }

    private static void moveToRightSlot(LinkedList<Integer> stack2, int numFromStack1) {
        if (!stack2.isEmpty() && stack2.peek() > numFromStack1) {
            int temp = stack2.pop();
            moveToRightSlot(stack2, numFromStack1);
            stack2.push(temp);
        } else {
            stack2.push(numFromStack1);
        }
    }
}
