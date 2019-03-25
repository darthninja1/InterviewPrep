package tree;

import static tree.TreeTraversal.preOrderTraversalRecursive;

public class RemoveSubtree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBalancedTree();
        preOrderTraversalRecursive(root);
        removeSubtree(root, 15);
        System.out.println();
        preOrderTraversalRecursive(root);
        removeSubtree(root, 100000);
        System.out.println();
        preOrderTraversalRecursive(root);
    }

    private static void removeSubtree(TreeNode root, int num) {
        if (root == null) return;

        if (root.left != null && root.left.value == num) {
            root.left = null;
        } else if (root.right != null && root.right.value == num) {
            root.right = null;
        } else {
            removeSubtree(root.left, num);
            removeSubtree(root.right, num);
        }
    }
}
