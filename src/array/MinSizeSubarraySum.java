package array;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen3(7, new int[]{2, 3, 1, 2, 4, 3}));

        System.out.println(minSubArrayLen(17, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen2(17, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen3(17, new int[]{2, 3, 1, 2, 4, 3}));

        System.out.println(minSubArrayLen(8, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen2(8, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen3(8, new int[]{2, 3, 1, 2, 4, 3}));
    }

    private static int minSubArrayLen(int sum, int[] nums) {
        int start = 0;
        int end = 0;
        int currentSum = 0;
        int minCount = Integer.MAX_VALUE;

        while (end < nums.length) {
            currentSum += nums[end++];
            while (currentSum >= sum) {
                minCount = Math.min(minCount, end - start);
                currentSum -= nums[start++];
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    private static int minSubArrayLen2(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minCount = Integer.MAX_VALUE;
        int count = 0;

        while (start < nums.length) {
            if (sum < s && end < nums.length) {
                sum += nums[end++];
                count++;
            } else if (sum >= s) {
                sum -= nums[start];
                if (count < minCount) {
                    minCount = count;
                }
                start++;
                count--;
            } else {
                break;
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    private static int minSubArrayLen3(int sum, int[] nums) {
        int start = 0;
        int end = 0;
        int currentSum = 0;
        int minCount = Integer.MAX_VALUE;

        while (end < nums.length) {
            while (end < nums.length && currentSum <= sum) {
                currentSum += nums[end++];
            }
            // we've reached the end, but unable to add up to sum
            if (currentSum < sum) {
                break;
            }
            while (currentSum >= sum) {
                minCount = Math.min(minCount, end - start);
                currentSum -= nums[start++];
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}
