package string;

// https://leetcode.com/problems/is-subsequence/
// https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "afhcbrfce"));
        System.out.println(isSubsequence("abx", "afhcbrfce"));
        System.out.println(isSubsequence("bad","bderrsamtgbhyd"));
    }

    private static boolean isSubsequence(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        int index = 0;
        for (int i = 0; i < s2.length() && index < s1.length(); i++) {
            if (s2.charAt(i) == s1.charAt(index)) {
                index++;
            }
        }
        if (index == s1.length()) return true;
        return false;
    }
}
