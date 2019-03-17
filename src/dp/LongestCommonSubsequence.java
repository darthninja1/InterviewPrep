package dp;

// http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequenceLength("aabcd", "abcde", 0, 0));
        System.out.println(longestCommonSubsequenceLength("abcd", "xyz", 0, 0));
        System.out.println(longestCommonSubsequenceLength("aabscdfw", "abxcdew", 0, 0));

        System.out.println(lcsTopDown("aabcd", "abcde", 0, 0));
        System.out.println(lcsTopDown("abcd", "xyz", 0, 0));
        System.out.println(lcsTopDown("aabscdfw", "abxcdew", 0, 0));

        System.out.println(lcsBottomUp("aabcd", "abcde"));
        System.out.println(lcsBottomUp("abcd", "xyz"));
        System.out.println(lcsBottomUp("aabscdfwlkaka", "abxcdewppppppppp"));
    }

    static int longestCommonSubsequenceLength(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longestCommonSubsequenceLength(s1, s2, i + 1, j + 1);
        }
        int temp1 = longestCommonSubsequenceLength(s1, s2, i + 1, j);
        int temp2 = longestCommonSubsequenceLength(s1, s2, i, j + 1);
        return Math.max(temp1, temp2);
    }

    static int lcsTopDown(String s1, String s2, int i, int j) {
        return lcsTopDownHelper(s1, s2, i, j, new Integer[s1.length()][s2.length()]);
    }

    private static int lcsTopDownHelper(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] == null) {
            if (s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = 1 + lcsTopDownHelper(s1, s2, i + 1, j + 1, dp);
            } else {
                int temp1 = lcsTopDownHelper(s1, s2, i + 1, j, dp);
                int temp2 = lcsTopDownHelper(s1, s2, i, j + 1, dp);
                dp[i][j] = Math.max(temp1, temp2);
            }
        }
        return dp[i][j];
    }

    static int lcsBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        /*
        // If using boxed types the below for-loops are required
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        */
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
