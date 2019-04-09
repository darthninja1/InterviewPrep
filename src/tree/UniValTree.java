package tree;

// https://www.dailycodingproblem.com/blog/unival-trees/
public class UniValTree {
    public static void main(String[] args) {
        /*
                    1
                   / \
                  1   1
                 / \
                1   1
         */
        TreeNode root1 = new TreeNode(1).withRightNode(1).withLeftNode(new TreeNode(1).withRightNode(1).withLeftNode(1));
        System.out.println(uniValCount(root1));
        System.out.println(isUniValOptimized(root1).count);

        /*
                    1
                   / \
                  1   1
                 / \
                1   2
         */
        TreeNode root2 = new TreeNode(1).withRightNode(1).withLeftNode(new TreeNode(1).withRightNode(2).withLeftNode(1));
        System.out.println(uniValCount(root2));
        System.out.println(isUniValOptimized(root2).count);

        /*
                    1
                   / \
                  2   1
                     / \
                    1   1
         */
        TreeNode root3 = new TreeNode(1).withLeftNode(2).withRightNode(new TreeNode(1).withRightNode(1).withLeftNode(1));
        System.out.println(uniValCount(root3));
        System.out.println(isUniValOptimized(root3).count);
    }

    private static int uniValCount(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int count = uniValCount(left) + uniValCount(right);
        if (isUniVal(root)) {
            count++;
        }
        return count;
    }

    private static boolean isUniVal(TreeNode root) {
        if (root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null && root.value != left.value) {
            return false;
        }
        if (right != null && root.value != right.value) {
            return false;
        }
        if (isUniVal(left) && isUniVal(right)) {
            return true;
        }
        return false;
    }

    private static Result isUniValOptimized(TreeNode root) {
        if (root == null) return new Result(true, 0);
        TreeNode left = root.left;
        TreeNode right = root.right;
        Result leftResult = isUniValOptimized(left);
        Result rightResult = isUniValOptimized(right);
        int count = 0;
        if (leftResult.isUniVal && rightResult.isUniVal) {
            if (left != null && root.value != left.value ||
                    right != null && root.value != right.value) {
                return new Result(false, leftResult.count + rightResult.count);
            } else {
                return new Result(true, 1 + leftResult.count + rightResult.count);
            }
        }
        return new Result(false, leftResult.count + rightResult.count);
    }

    private static class Result {
        boolean isUniVal;
        int count;

        private Result(boolean isUniVal, int count) {
            this.isUniVal = isUniVal;
            this.count = count;
        }
    }
}