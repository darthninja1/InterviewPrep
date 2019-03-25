package tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

import static tree.TreeTraversal.*;

// https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
public class BinaryTreeFromArray {
    public static void main(String[] args) {
        TreeNode root = constructTreeIterative(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        inOrderTraversalRecursive(root);
        System.out.println();
        preOrderTraversalRecursive(root);
        System.out.println();
        breadFirstIterative(root);
        System.out.println();

        TreeNode root1 = constructTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0);
        inOrderTraversalRecursive(root1);
        System.out.println();
        preOrderTraversalRecursive(root1);
        System.out.println();
        breadFirstIterative(root1);
        System.out.println();
    }

    private static TreeNode constructTreeIterative(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        if (arr.length == 1) return root;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek().getKey();
            int index = queue.remove().getValue();
            if (2 * index + 1 < arr.length) {
                TreeNode left = new TreeNode(arr[2 * index + 1]);
                node.withLeftNode(left);
                queue.add(new Pair<>(left, 2 * index + 1));
            }
            if (2 * index + 2 < arr.length) {
                TreeNode right = new TreeNode(arr[2 * index + 2]);
                node.withRightNode(right);
                queue.add(new Pair<>(right, 2 * index + 2));
            }

        }
        return root;
    }

    private static TreeNode constructTree(int[] arr, int index) {
        TreeNode root = new TreeNode(arr[index]);
        if (2 * index + 1 < arr.length) {
            root.withLeftNode(constructTree(arr, 2*index+1));
        }
        if (2 * index + 2 < arr.length) {
            root.withRightNode(constructTree(arr, 2*index+2));
        }
        return root;
    }
}
