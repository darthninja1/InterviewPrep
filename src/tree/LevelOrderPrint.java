package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPrint {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBalancedTree();
        levelOrder(root);
    }

    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.remove();
                size--;
                System.out.print(node.value + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}