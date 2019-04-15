package tree;

import java.util.Deque;
import java.util.LinkedList;

import static tree.TreeTraversal.breadFirstIterative;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeDeserialize {
    public static void main(String[] args) {
        String s;
        System.out.println(s = serialize(TreeNode.createTree()));
        TreeNode root = deserialize(s);
        breadFirstIterative(root);
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            sb.append('\0');
        } else {
            queue.addFirst(root);

            while (!queue.isEmpty()) {
                TreeNode temp = queue.removeLast();
                if (temp != null) {
                    sb.append(temp.value).append(',');
                    if (temp.left != null) {
                        queue.addFirst(temp.left);
                    } else {
                        queue.addFirst(null);
                    }
                    if (temp.right != null) {
                        queue.addFirst(temp.right);
                    } else {
                        queue.addFirst(null);
                    }
                } else {
                    sb.append('\0').append(',');
                }
            }
        }
        return sb.toString();
    }

    private static TreeNode deserialize(String s) {
        if (s.length() == 1 && s.charAt(0) == '\0') {
            return null;
        }
        int idx = s.indexOf(',');
        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, idx)));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeLast();
            if (idx + 1 < s.length()) {
                int next = s.indexOf(',', idx + 1);
                if (next != -1) {
                    String num = s.substring(idx + 1, next);
                    if (num.charAt(0) != '\0') {
                        TreeNode left = new TreeNode(Integer.valueOf(num));
                        temp.withLeftNode(left);
                        queue.addFirst(left);
                    }
                    idx = next;
                }
            }
            if (idx + 1 < s.length()) {
                int next = s.indexOf(',', idx + 1);
                if (next != -1) {
                    String num = s.substring(idx + 1, next);
                    if (num.charAt(0) != '\0') {
                        TreeNode right = new TreeNode(Integer.valueOf(num));
                        temp.withRightNode(right);
                        queue.addFirst(right);
                    }
                    idx = next;
                }
            }
        }
        return root;
    }
}