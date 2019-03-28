package stack;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BalancedParenthesis {
    public static void main(String[] args) {
        System.out.println(isBalanced("(([{[]}]))"));
        System.out.println(isBalanced("(([{[}]))"));
        System.out.println(isBalanced("(([{["));
        System.out.println(isBalanced("(([{[]]}))"));
        System.out.println(isBalanced("]}]))"));
    }

    private static boolean isBalanced(String s) {
        Map<Character, Character> mapping = ImmutableMap.of('{', '}', '[', ']', '(', ')');
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if ("([{".indexOf((int) c) != -1) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || c != mapping.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
