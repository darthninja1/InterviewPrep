package tree;

import static tree.TreeNode.createTree;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(isSymmetric(root));
        /*
                     40
                   /   \
                  10    10
                 /        \
                5          5
               / \        / \
              7   9      9   7
         */
        TreeNode left = new TreeNode(10);
        TreeNode right = new TreeNode(10);
        root = new TreeNode(40).withLeftNode(left).withRightNode(right);
        left.withLeftNode(new TreeNode(5).withLeftNode(7).withRightNode(9));
        right.withRightNode(new TreeNode(5).withLeftNode(9).withRightNode(7));
        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.value != right.value) return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
