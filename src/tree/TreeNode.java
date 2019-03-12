package tree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode withLeftNode(TreeNode leftNode) {
        this.left = leftNode;
        return this;
    }

    public TreeNode withRightNode(TreeNode rightNode) {
        this.right = rightNode;
        return this;
    }
}
