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
        root = deserialize2(s);
        breadFirstIterative(root);
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            sb.append('X');
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
                    sb.append('X').append(',');
                }
            }
        }
        return sb.toString();
    }

    static TreeNode deserialize(String s) {
        if (s.length() == 1 && s.charAt(0) == 'X') {
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
                    if (num.charAt(0) != 'X') {
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
                    if (num.charAt(0) != 'X') {
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

    private static TreeNode deserialize2(String s) {
        if (s.length() == 1 && s.charAt(0) == 'X') {
            return null;
        }
        String[] arr = s.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeLast();
            if (arr[idx].charAt(0) != 'X') {
                TreeNode left = new TreeNode(Integer.valueOf(arr[idx]));
                temp.withLeftNode(left);
                queue.addFirst(left);
            }
            idx++;
            if (arr[idx].charAt(0) != 'X') {
                TreeNode right = new TreeNode(Integer.valueOf(arr[idx]));
                temp.withRightNode(right);
                queue.addFirst(right);
            }
            idx++;
        }
        return root;
    }
}