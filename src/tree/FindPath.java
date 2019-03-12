package tree;

import java.util.ArrayList;
import java.util.List;

public class FindPath {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        System.out.println(findPath(root, 9));
    }

    private static List<Integer> findPath(TreeNode root, int value) {
        List<Integer> path = new ArrayList<>();
        findPath(root, value, path);
        return path;
    }

    private static boolean findPath(TreeNode root, int value, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.value);
        if (root.value == value) {
            return true;
        }
        if (findPath(root.left, value, path)) {
            return true;
        }
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
