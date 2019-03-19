package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
public class ListOfPathSumFromRootToLeaf {
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
        pathSumList1(root, 18);
        pathSumList2(root, 18);
        pathSumList1(root, 10);
        pathSumList2(root, 10);
        pathSumList1(root, 11);
        pathSumList2(root, 11);
    }

    private static void pathSumList1(TreeNode root, int sum) {
        HashSet<List<Integer>> setOfPaths = new HashSet<>();
        pathSumList(root, sum, new ArrayList<>(), 0, setOfPaths);
        System.out.println(setOfPaths);

    }

    private static void pathSumList2(TreeNode root, int sum) {
        HashSet<List<Integer>> setOfPaths = new HashSet<>();
        pathSumList(root, sum, new ArrayList<>(), setOfPaths);
        System.out.println(setOfPaths);
    }

    // Better solution as we dont need to keep track of index, but it means we need to delete the last entry in the list before returning
    private static void pathSumList(TreeNode root, int sum, List<Integer> prefixPath, HashSet<List<Integer>> setOfPaths) {
        if (root == null) return;

        prefixPath.add(root.value);

        if (root.value == sum && root.left == null && root.right == null) {
            setOfPaths.add(new ArrayList<>(prefixPath));
            prefixPath.remove(prefixPath.size() - 1);
            return;
        }
        pathSumList(root.right, sum - root.value, prefixPath, setOfPaths);
        pathSumList(root.left, sum - root.value, prefixPath, setOfPaths);
        prefixPath.remove(prefixPath.size() - 1);
    }

    private static void pathSumList(TreeNode root, int sum, List<Integer> prefixPath, int index, HashSet<List<Integer>> setOfPaths) {
        if (root == null) {
            return;
        }

        prefixPath.add(index, root.value);
        index++;

        if (root.value == sum && root.left == null && root.right == null) {
            setOfPaths.add(new ArrayList<>(prefixPath.subList(0, index)));
            return;
        }
        pathSumList(root.right, sum - root.value, prefixPath, index, setOfPaths);
        pathSumList(root.left, sum - root.value, prefixPath, index, setOfPaths);
    }
}