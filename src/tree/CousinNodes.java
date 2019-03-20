package tree;

import static tree.SiblingNodes.isSibling;

// https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
public class CousinNodes {
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(isCousin(root, 12, 0));
        System.out.println(isCousin(root, 12, -3));
        System.out.println(isCousin(root, 13, 2));
        System.out.println(isCousin(root, 13, 0));
        System.out.println(isCousin(root, 3, 4));
    }

    static TreeNode createTree() {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(-8);
        TreeNode root = new TreeNode(10).withLeftNode(left).withRightNode(right);
        left.withLeftNode(new TreeNode(3).withLeftNode(new TreeNode(13).withRightNode(-3)).withRightNode(0))
                .withRightNode(new TreeNode(2).withRightNode(1));
        right.withLeftNode(new TreeNode(4).withLeftNode(6).withRightNode(12)).withRightNode(new TreeNode(11).withRightNode(14));
        /*
                    10
                 /     \
                5       -8
               / \      / \
              3   2    4  11
             / \   \  / \   \
            13  0  1 6  12  14
             \
             -3
        */
        return root;
    }

    private static boolean isCousin(TreeNode root, int value1, int value2) {
        int level1 = getHeightOf(root, value1, 1);
        int level2 = getHeightOf(root, value2, 1);
        if (level1 != level2) return false;
        if (!isSibling(root, value1, value2)) return true;
        return false;
    }

    private static int getHeightOf(TreeNode root, int value, int level) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.value == value) return level;
        int left = getHeightOf(root.left, value, level + 1);
        if (left != Integer.MIN_VALUE) {
            return left;
        }
        return getHeightOf(root.right, value, level + 1);

    }
}
