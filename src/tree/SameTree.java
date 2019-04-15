package tree;

// https://leetcode.com/problems/same-tree/
public class SameTree {
    public static void main(String[] args) {
        TreeNode t1 = TreeNode.createTree();
        TreeNode t2 = TreeNode.createBalancedTree();
        System.out.println(isSameTree(t1, t2));
        System.out.println(isSameTree(t1, TreeNode.createTree()));
    }

    private static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {
            if (t1.value != t2.value) {
                return false;
            } else {
                return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
            }
        }
    }
}