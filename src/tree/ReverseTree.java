package tree;

import static tree.TreeNode.createTree;
import static tree.TreeTraversal.inOrderTraversalRecursive;

// https://leetcode.com/problems/invert-binary-tree/
public class ReverseTree {
    public static void main(String[] args) {
        TreeNode root = createTree();
        inOrderTraversalRecursive(root);
        System.out.println();
        reverse(root);
        inOrderTraversalRecursive(root);
    }

    private static void reverse(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
    }
}
