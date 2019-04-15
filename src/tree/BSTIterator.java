package tree;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import static tree.BinarySearchTree.createBSTRecursive;

// https://leetcode.com/problems/binary-search-tree-iterator/
public class BSTIterator implements Iterator<TreeNode> {
    private Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBSTRecursive();
        BSTIterator iterator = new BSTIterator(root);
        System.out.println();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().value + " ");
        }
        System.out.println();
    }

    @Override
    public boolean hasNext() {
        return stack.size() > 0;
    }

    @Override
    public TreeNode next() {
        TreeNode nextNode = stack.pop();
        TreeNode temp = nextNode.right;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        return nextNode;
    }
}
