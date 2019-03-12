package tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value) {
        this.value = value;
    }

    static TreeNode createTree() {
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
        left.withLeftNode(new TreeNode(5).withLeftNode(7).withRightNode(9));
        right.withLeftNode(new TreeNode(15).withLeftNode(77).withRightNode(89));
        return root;
    }

    static TreeNode createBalancedTree() {
        /*
                                 40
                             /       \
                            10        100
                           /  \      /   \
                          5   18    15    21
                         / \    \   / \     \
                        7   9    4 77  89   54
         */
        TreeNode left = new TreeNode(10);
        TreeNode right = new TreeNode(100);
        TreeNode root = new TreeNode(40).withLeftNode(left).withRightNode(right);
        left.withLeftNode(new TreeNode(5).withLeftNode(7).withRightNode(9));
        left.withRightNode(new TreeNode(18).withRightNode(4));
        right.withLeftNode(new TreeNode(15).withLeftNode(77).withRightNode(89));
        right.withRightNode(new TreeNode(21).withRightNode(54));
        return root;
    }

    TreeNode withLeftNode(int value) {
        this.left = new TreeNode(value);
        return this;
    }

    TreeNode withRightNode(int value) {
        this.right = new TreeNode(value);
        return this;
    }

    TreeNode withLeftNode(TreeNode leftNode) {
        this.left = leftNode;
        return this;
    }

    TreeNode withRightNode(TreeNode rightNode) {
        this.right = rightNode;
        return this;
    }

    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
