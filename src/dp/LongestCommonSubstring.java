package dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(lcs("aabcd", "abcde", 0, 0, 0));
        System.out.println(lcs("abcd", "xyz", 0, 0, 0));
        System.out.println(lcs("aabzscdfw", "abzcdew", 0, 0, 0));
        System.out.println(lcsBottomUp("aabcd", "abcde"));
        System.out.println(lcsBottomUp("abcd", "xyz"));
        System.out.println(lcsBottomUp("aabzscdfw", "abzcdew"));
    }

    private static int lcs(String s1, String s2, int i, int j, int count) {
        if (i == s1.length() || j == s2.length()) {
            return count;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            count = lcs(s1, s2, i + 1, j + 1, count + 1);
        }
        int c1 = lcs(s1, s2, i + 1, j, 0);
        int c2 = lcs(s1, s2, i, j + 1, 0);
        return Math.max(count, Math.max(c1, c2));
    }

    private static int lcsBottomUp(String s1, String s2) {
        int[][] dp = new int[1 + s1.length()][1 + s2.length()];
        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }
}