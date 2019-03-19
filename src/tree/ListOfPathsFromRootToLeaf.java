package tree;

import java.util.ArrayList;
import java.util.List;

// https://www.programcreek.com/2014/05/leetcode-binary-tree-paths-java/
// https://leetcode.com/problems/binary-tree-paths/
public class ListOfPathsFromRootToLeaf {
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
        pathSumList(root);
        pathSumStringList(root);
    }

    private static void pathSumList(TreeNode root) {
        List<List<Integer>> setOfPaths = new ArrayList<>();
        pathSumList(root, new ArrayList<>(), setOfPaths);
        System.out.println(setOfPaths);
    }

    // Better solution as we dont need to keep track of index, but it means we need to delete the last entry in the list before returning
    private static void pathSumList(TreeNode root, List<Integer> prefixPath, List<List<Integer>> setOfPaths) {
        if (root == null) return;

        prefixPath.add(root.value);

        if (root.left == null && root.right == null) {
            setOfPaths.add(new ArrayList<>(prefixPath));
            prefixPath.remove(prefixPath.size() - 1);
            return;
        }
        pathSumList(root.right, prefixPath, setOfPaths);
        pathSumList(root.left, prefixPath, setOfPaths);
        prefixPath.remove(prefixPath.size() - 1);
    }

    private static void pathSumStringList(TreeNode root) {
        List<String> setOfPaths = new ArrayList<>();
        pathSumStringList(root, "", setOfPaths);
        System.out.println(setOfPaths);
    }

    private static void pathSumStringList(TreeNode root, String prefixPath, List<String> setOfPaths) {
        if (root == null) return;

        prefixPath = prefixPath + " " + root.value;

        if (root.left == null && root.right == null) {
            setOfPaths.add(prefixPath);
            return;
        }
        pathSumStringList(root.right, prefixPath, setOfPaths);
        pathSumStringList(root.left, prefixPath, setOfPaths);
    }
}