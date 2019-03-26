package tree;

import static tree.TreeNode.height;
import static tree.TreeTraversal.inOrderTraversalIterative;
import static tree.TreeTraversal.inOrderTraversalRecursive;

public class BinarySearchTree {
    static TreeNode insertRecursive(TreeNode root, int newValue) {
        if (root == null) {
            return new TreeNode(newValue);
        }
        if (root.value > newValue) {
            root.left = insertRecursive(root.left, newValue);
        } else {
            root.right = insertRecursive(root.right, newValue);
        }
        return root;
    }

    static TreeNode insertIterative(TreeNode root, int newValue) {
        TreeNode child = new TreeNode(newValue);
        if (root == null) {
            return child;
        }
        TreeNode current = root;
        TreeNode prev = null;
        while (current != null) {
            prev = current;
            if (current.value > newValue) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (prev.value > newValue) {
            prev.left = new TreeNode(newValue);
        } else {
            prev.right = new TreeNode(newValue);
        }
        return root;
    }

    static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.value < root.left.value) {
            return false;
        }
        if (root.right != null && root.value > root.right.value) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    static boolean isPresent(TreeNode root, int value) {
        return find(root, value) != null;
    }

    static TreeNode find(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        } else if (root.value > value) {
            return find(root.left, value);
        } else {
            return find(root.right, value);
        }
    }

    private static int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    static TreeNode deleteNode(TreeNode root, int num) {
        if (root == null) {
            return null;
        }
        if (root.value > num) {
            root.left = deleteNode(root.left, num);
        } else if (root.value < num) {
            root.right = deleteNode(root.right, num);
        } else { // found node
            if (root.left != null && root.right != null) {
                // find smallest right node and promote it as root
                int min = findMin(root.right);
                deleteNode(root.right, min);
                root.value = min;
            } else if (root.left != null || root.right != null) {
                // only 1 child, make root point to it
                root = (root.left == null) ? root.right : root.left;
            } else { // no children
                root = null;
            }
        }
        return root;
    }

    static TreeNode createBSTRecursive() {
        TreeNode root = insertRecursive(null, 33);
        insertRecursive(root, 20);
        insertRecursive(root, 45);
        insertRecursive(root, 19);
        insertRecursive(root, 27);
        insertRecursive(root, 30);
        insertRecursive(root, 87);
        insertRecursive(root, 40);
        insertRecursive(root, 67);
        inOrderTraversalRecursive(root);
        return root;
    }

    static TreeNode createBSTIterative() {
        TreeNode root = insertIterative(null, 33);
        insertIterative(root, 20);
        insertIterative(root, 45);
        insertIterative(root, 19);
        insertIterative(root, 27);
        insertIterative(root, 30);
        insertIterative(root, 87);
        insertIterative(root, 40);
        insertIterative(root, 67);
        inOrderTraversalIterative(root);
        return root;
    }

    public static void main(String[] args) {
        System.out.print("BST recursive: ");
        TreeNode root = createBSTRecursive();
        System.out.println("\nHeight: " + height(root));
        System.out.println("isBST: " + isBST(root));
        System.out.println("Find 40: " + isPresent(root, 40));
        System.out.println("Find 18: " + isPresent(root, 18));

        System.out.print("\nBST iterative: ");
        root = createBSTIterative();
        System.out.println("Height: " + height(root));
        System.out.println("isBST: " + isBST(root));
        System.out.println("Find 49: " + isPresent(root, 49));
        System.out.println("Find 87: " + isPresent(root, 87));

        System.out.println("Deleting node 87...");
        deleteNode(root, 87);
        inOrderTraversalRecursive(root);
        System.out.println();

        System.out.println("Deleting node 33...");
        deleteNode(root, 33);
        inOrderTraversalRecursive(root);
        System.out.println();

        System.out.println("Deleting node 5555...");
        deleteNode(root, 5555);
        inOrderTraversalRecursive(root);
        System.out.println();

        System.out.println("Deleting node 67...");
        deleteNode(root, 67);
        inOrderTraversalRecursive(root);
        System.out.println();
    }
}

