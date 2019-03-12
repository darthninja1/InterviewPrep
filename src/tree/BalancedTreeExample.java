package tree;

import static tree.TreeNode.*;

public class BalancedTreeExample {
    public static void main(String[] args) {
        System.out.println(isBalanced(null));
        System.out.println(isBalanced(new TreeNode(10)));
        System.out.println(isBalanced(new TreeNode(10).withLeftNode(20)));
        System.out.println(isBalanced(createTree()));
        System.out.println(isBalanced(createBalancedTree()));
    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftTreeSize = height(root.left);
        int rightTreeSize = height(root.right);

        return Math.abs(leftTreeSize - rightTreeSize) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
