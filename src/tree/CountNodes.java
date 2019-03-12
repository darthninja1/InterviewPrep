package tree;

public class CountNodes {
    public static void main(String[] args) {
        System.out.println(count(TreeNode.createTree()));
        System.out.println(count(TreeNode.createBalancedTree()));
    }

    private static int count(TreeNode root) {
        return root == null ? 0 : count(root.left) + count(root.right) + 1;
    }
}
