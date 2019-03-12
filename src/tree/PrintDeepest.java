package tree;

import static tree.TreeNode.height;

public class PrintDeepest {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        deepest(root, height(root));
        root = TreeNode.createBalancedTree();
        deepest(root, height(root));
    }

    private static void deepest(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height == 1) {
            System.out.println(root.value);
        }
        deepest(root.left, height - 1);
        deepest(root.right, height - 1);
    }
}
