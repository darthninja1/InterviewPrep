package tree;

import javafx.util.Pair;

import java.util.LinkedList;

// https://leetcode.com/problems/path-sum/
// https://www.programcreek.com/2013/01/leetcode-path-sum/
public class PathSumFromRootToLeaf {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(-3);
        TreeNode root = new TreeNode(10).withLeftNode(left).withRightNode(right);
        left.withLeftNode(new TreeNode(3).withLeftNode(new TreeNode(3).withRightNode(-3)).withRightNode(0))
                .withRightNode(new TreeNode(2).withRightNode(new TreeNode(1)));
        right.withRightNode(11).withLeftNode(4);

        /*
                   10
                 /   \
                5     -3
               / \    / \
              3   2  4  11
             / \   \
            3  0   1
             \
             -3
         */
        System.out.println(pathSum(root, 18));
        System.out.println(pathSumIterative(root, 18));
        System.out.println(pathSumCount(root, 18));
        System.out.println(pathSum(root, 11));
        System.out.println(pathSumIterative(root, 11));
        System.out.println(pathSumCount(root, 11));
    }

    private static boolean pathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.value == sum && root.left == null && root.right == null) return true;

        return pathSum(root.right, sum - root.value) || pathSum(root.left, sum - root.value);
    }

    private static int pathSumCount(TreeNode root, int sum) {
        if (root == null) return 0;

        if (root.value == sum && root.left == null && root.right == null) return 1;

        return pathSumCount(root.right, sum - root.value) + pathSumCount(root.left, sum - root.value);
    }

    private static boolean pathSumIterative(TreeNode root, int sum) {
        LinkedList<Pair<TreeNode, Integer>> list = new LinkedList<>();

        list.add(new Pair<>(root, sum));

        while (!list.isEmpty()) {
            Pair<TreeNode, Integer> pair = list.poll();
            TreeNode node = pair.getKey();
            if (node == null) return false;
            if (node.value == pair.getValue() && node.left == null && node.right == null) {
                return true;
            }
            list.add(new Pair<>(node.left, pair.getValue() - node.value));
            list.add(new Pair<>(node.right, pair.getValue() - node.value));
        }
        return false;
    }
}
