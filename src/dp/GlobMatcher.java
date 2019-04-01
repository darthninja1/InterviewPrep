package dp;

public class GlobMatcher {
    public static void main(String[] args) {
        isMatch("abcd", "a?bcd");
        isMatch("abcd", "a*bcd");
        isMatch("abcd", "a*cd");
        isMatch("abcd", "a*cde");
        isMatch("abcd", "a*cd*");
        isMatch("", "***");
        isMatch("", "");
        isMatch("abc", "a*?*c*");
    }

    private static void isMatch(String target, String glob) {
        System.out.println(isMatchRecursive(target, glob) + " <-> " + isMatchDynamic(target, glob));
    }

    private static boolean isMatchDynamic(String target, String glob) {
        boolean[][] dp = new boolean[target.length() + 1][glob.length() + 1];

        // initialize dp matrix
        dp[0][0] = true;
        for (int j = 1; j <= glob.length(); j++) {
            if (glob.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= target.length(); i++) {
            for (int j = 1; j <= glob.length(); j++) {
                if (glob.charAt(j - 1) != '*') {
                    if (target.charAt(i - 1) == glob.charAt(j - 1) || glob.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    // Exclude & Include the *
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
//        print(dp);
        return dp[target.length()][glob.length()];
    }

    private static boolean isMatchRecursive(String target, String glob) {
        return isMatchRecursiveHelper(target, glob, 0, 0);
    }

    private static boolean isMatchRecursiveHelper(String target, String glob, int i, int j) {
        if (i == target.length() && j == glob.length()) {
            return true;
        }
        if (i >= target.length() || j >= glob.length()) {
            if (glob.charAt(j) == '*') {
                return isMatchRecursiveHelper(target, glob, i, j + 1);
            }
            return false;
        }
        if (glob.charAt(j) != '*') {
            if (target.charAt(i) == glob.charAt(j) || glob.charAt(j) == '?') {
                return isMatchRecursiveHelper(target, glob, i + 1, j + 1);
            } else {
                return false;
            }
        } else {
            boolean exclude = isMatchRecursiveHelper(target, glob, i, j + 1);
            boolean include = isMatchRecursiveHelper(target, glob, i + 1, j);
            return exclude || include;
        }
    }
}
