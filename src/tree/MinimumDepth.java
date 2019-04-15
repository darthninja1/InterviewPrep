package tree;

import java.util.Deque;
import java.util.LinkedList;

import static tree.SerializeDeserialize.deserialize;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepth {
    public static void main(String[] args) {
        TreeNode root = deserialize("3,9,20,X,X,15,7");
        System.out.println(minDepth(root));
        System.out.println(minDepth2(root));
        System.out.println(minDepth(TreeNode.createTree()));
        System.out.println(minDepth2(TreeNode.createTree()));
    }

    private static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) {
            return minDepth(root.left == null ? root.right : root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    private static int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int minHeight = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minHeight++;
            while (size > 0) {
                TreeNode temp = queue.removeLast();
                size--;
                if (temp.left == null && temp.right == null) {
                    return minHeight;
                }
                if (temp.left != null) {
                    queue.addFirst(temp.left);
                }
                if (temp.right != null) {
                    queue.addFirst(temp.right);
                }
            }
        }
        return minHeight;
    }
}