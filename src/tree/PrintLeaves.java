package tree;

import static tree.TreeNode.createBalancedTree;
import static tree.TreeNode.createTree;

public class PrintLeaves {
    public static void main(String[] args) {
        printLeaves(createTree());
        System.out.println();
        printLeaves(createBalancedTree());
    }

    private static void printLeaves(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.value + " ");
        }

        printLeaves(root.left);
        printLeaves(root.right);
    }
}
