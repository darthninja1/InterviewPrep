package tree;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/path-sum-iii/description/
public class PathSumFromAnyNode {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(-3);
        TreeNode root = new TreeNode(10).withLeftNode(left).withRightNode(right);
        left.withLeftNode(new TreeNode(3).withLeftNode(3).withRightNode(-2))
                .withRightNode(new TreeNode(2).withRightNode(new TreeNode(1)));
        right.withRightNode(11);

        /*
                  10
                 /  \
                5   -3
               / \    \
              3   2   11
             / \   \
            3  -2   1
         */
        System.out.println(pathSum(root, 7));
        System.out.println(pathSumWithMap(root, 7));
        System.out.println(pathSum(root, 18));
        System.out.println(pathSumWithMap(root, 18));
    }

    // calculate number of paths from this node, and
    // recursively call pathSum from left and right children
    static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return numberOfPathsFromNode(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    static int numberOfPathsFromNode(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.value == sum ? 1 : 0)
                + numberOfPathsFromNode(node.left, sum - node.value) + numberOfPathsFromNode(node.right, sum - node.value);
    }

    static int pathSumWithMap(TreeNode root, int target) {
        Map<Integer /*partial sum*/, Integer /*count*/> map = new HashMap<>();
        map.put(0, 1); // base case, if sum=0, we found a match
        return pathSumWithMap(root, target, map, 0);
    }

    static int pathSumWithMap(TreeNode root, int target, Map<Integer, Integer> map, int prefixSum) {
        if (root == null) return 0;
        // Update prefix sum with current node's value
        prefixSum += root.value;

        // what's the current count of the remaining sum
        int count = map.getOrDefault(prefixSum - target, 0);

        // update the remaining sum count
        map.put(prefixSum, map.getOrDefault(prefixSum - target, 0) + 1);

        int leftCount = pathSumWithMap(root.left, target, map, prefixSum);
        int rightCount = pathSumWithMap(root.right, target, map, prefixSum);
        return count + leftCount + rightCount;
    }
}