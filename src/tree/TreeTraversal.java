package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeTraversal {
    public static void main(String[] args) {
        /*
                              40
                             /  \
                            10  100
                           /     /
                          5     15
                         / \    / \
                        7   9  77  89

         */
        TreeNode left = new TreeNode(10);
        TreeNode right = new TreeNode(100);
        TreeNode root = new TreeNode(40).withLeftNode(left).withRightNode(right);
        left.withLeftNode(new TreeNode(5).withLeftNode(new TreeNode(7)).withRightNode(new TreeNode(9)));
        right.withLeftNode(new TreeNode(15).withLeftNode(new TreeNode(77)).withRightNode(new TreeNode(89)));
        System.out.println("Recursive Traversal -");
        inOrderTraversalRecursive(root);
        System.out.println("\nIterative Traversal -");
        inOrderTraversalIterative(root);
        System.out.println("\nBreadth First Traversal -");
        breadFirstIterative(root);
    }

    private static void inOrderTraversalIterative(TreeNode root) {
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

    private static void inOrderTraversalRecursive(TreeNode root) {
        if (root.left != null) inOrderTraversalRecursive(root.left);
        System.out.print(root.value + " ");
        if (root.right != null) inOrderTraversalRecursive(root.right);
    }

    private static void breadFirstIterative(TreeNode root) {
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
