package tree;

import static tree.CousinNodes.createTree;

public class SiblingNodes {

    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(isSibling(root, 5, -8));
        System.out.println(isSibling(root, 12, -3));
        System.out.println(isSibling(root, 13, 2));
        System.out.println(isSibling(root, 13, 0));
        System.out.println(isSibling(root, 3, 4));
    }

    static boolean isSibling(TreeNode root, int value1, int value2) {
        if (root == null) return false;
        TreeNode left = root.left;
        TreeNode right = root.right;

        boolean b1 = false;
        if (left != null && right != null) {
            b1 = ((left.value == value1 && right.value == value2) ||
                    (left.value == value2 && right.value == value1));
        }
        boolean b2 = false;
        if (left != null) {
            b2 = isSibling(left, value1, value2);
        }
        boolean b3 = false;
        if (right != null) {
            b3 = isSibling(right, value1, value2);
        }
        return b1 || b2 || b3;
    }
}
