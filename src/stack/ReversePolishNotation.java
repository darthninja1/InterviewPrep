package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ReversePolishNotation {
    static HashMap<String, RPNOperator> map = new HashMap<>();

    public static void main(String[] args) {
        String[] arr = new String[]{"1", "2", "+", "4", "*"};
        String[] arr2 = new String[]{"1", "-", "2", "+", "4", "*"};
        System.out.println(computeRPNNaive(arr));

        registerOperator(new Add());
        registerOperator(new Subtract());
        registerOperator(new Multiply());
        registerOperator(new Divide());
        System.out.println(computeRPN2(arr));
        System.out.println(computeRPN2(arr2));
    }

    private static int computeRPNNaive(String[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("error");

        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : arr) {
            if (!"+-*/".contains(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int rightOp = stack.pop();
                int leftOp = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(rightOp + leftOp);
                        break;
                    case "-":
                        stack.push(rightOp - leftOp);
                        break;
                    case "*":
                        stack.push(rightOp * leftOp);
                        break;
                    case "/":
                        if (leftOp == 0) throw new IllegalArgumentException("divide by zero");
                        stack.push(rightOp / leftOp);
                        break;
                    default:
                        throw new RuntimeException("error");
                }
            }
        }
        return stack.pop();
    }

    static void registerOperator(RPNOperator op) {
        map.put(op.getOperator(), op);
    }

    static int computeRPN2(String[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("error");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : arr) {
            if (!map.containsKey(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                map.get(s).compute(stack);
            }
        }
        return stack.pop();
    }

    public interface RPNOperator {
        String getOperator();

        void compute(Deque<Integer> stack);
    }

    public static class Add implements RPNOperator {

        @Override
        public String getOperator() {
            return "+";
        }

        @Override
        public void compute(Deque<Integer> stack) {
            int rightOp = stack.pop();
            int leftOp = stack.pop();
            stack.push(rightOp + leftOp);
        }
    }

    public static class Subtract implements RPNOperator {

        @Override
        public String getOperator() {
            return "-";
        }

        @Override
        public void compute(Deque<Integer> stack) {
            int rightOp = stack.pop();
            if (stack.peek() != null) {
                int leftOp = stack.pop();
                stack.push(rightOp - leftOp);
            } else { // unary
                stack.push(0 - rightOp);
            }
        }
    }

    public static class Multiply implements RPNOperator {

        @Override
        public String getOperator() {
            return "*";
        }

        @Override
        public void compute(Deque<Integer> stack) {
            int rightOp = stack.pop();
            int leftOp = stack.pop();
            stack.push(rightOp * leftOp);
        }
    }

    public static class Divide implements RPNOperator {

        @Override
        public String getOperator() {
            return "/";
        }

        @Override
        public void compute(Deque<Integer> stack) {
            int rightOp = stack.pop();
            int leftOp = stack.pop();
            if (leftOp == 0) throw new IllegalArgumentException("divide by zero");
            stack.push(rightOp / leftOp);
        }
    }
}
