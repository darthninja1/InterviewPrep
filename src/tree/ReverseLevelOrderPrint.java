package tree;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseLevelOrderPrint {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBalancedTree();
        reverselevelOrder(root);
        reverselevelOrder2(root);
    }

    private static void reverselevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.remove();
                stack.push(node);
                size--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            stack.push(null);
        }
        stack.pop();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                System.out.print(node.value + " ");
            } else {
                System.out.println();
            }
        }
        System.out.println("\n\n");
    }

    private static void reverselevelOrder2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            stack.push(size);
            while (size > 0) {
                TreeNode node = queue.remove();
                queue2.add(node);
                size--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        while (!stack.isEmpty()) {
            int count = stack.pop();
            while (count-- > 0) {
                System.out.print(queue2.pollLast() + " ");
            }
            System.out.println();
        }
    }
}