package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        System.out.println("Recursive Traversal -");
        inOrderTraversalRecursive(root);
        System.out.println("\nIterative Traversal -");
        inOrderTraversalIterative(root);
        System.out.println("\nBreadth First Traversal -");
        breadFirstIterative(root);
    }

    static void inOrderTraversalIterative(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;

        while (temp != null || stack.size() > 0) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.value + " ");
            temp = temp.right;
        }
        System.out.println();
    }

    static void inOrderTraversalRecursive(TreeNode root) {
        if (root.left != null) inOrderTraversalRecursive(root.left);
        System.out.print(root.value + " ");
        if (root.right != null) inOrderTraversalRecursive(root.right);
    }

    static void breadFirstIterative(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeLast();
            System.out.print(temp.value + " ");
            if (temp.left != null) {
                queue.addFirst(temp.left);
            }
            if (temp.right != null) {
                queue.addFirst(temp.right);
            }
        }
        System.out.println();
    }
}
