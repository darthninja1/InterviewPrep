package dp;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreakRecursive("applepenapple", Lists.newArrayList("apple", "pen")));
        System.out.println(wordBreakRecursive("leetcode", Lists.newArrayList("leet", "code")));
        System.out.println(wordBreakRecursive("catsandog", Lists.newArrayList("cat", "dog", "sand", "and", "cat")));
        System.out.println(wordBreakRecursive("aaaaaaa", Lists.newArrayList("aaaa", "aaa")));
        System.out.println(wordBreak("leetcode", Lists.newArrayList("leet", "code")));
        System.out.println(wordBreak("aaaaaaa", Lists.newArrayList("aaaa", "aaa")));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Lists.newArrayList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    private static boolean wordBreakRecursive(String s, List<String> wordDict) {
        Set<String> visited = new HashSet<>();
        return wordBreakRecursive(s, new HashSet<>(wordDict), visited);
    }

    private static boolean wordBreakRecursive(String s, Set<String> wordSet, Set<String> visited) {
        if (s.length() == 0) return true;
        for (int i = 1; i <= s.length(); i++) {
//            System.out.println("Matching:" + s.substring(0, i));
            if (wordSet.contains(s.substring(0, i))) {
//                System.out.println("Matching:" + s.substring(0, i) + ", remaining: " + s.substring(i));
                if (!visited.contains(s.substring(i))) {
                    if (wordBreakRecursive(s.substring(i), wordSet, visited)) {
                        visited.add(s.substring(i));
                        return true;
                    }
                }
            }
        }
//        System.out.println("Failed...");
        return false;
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
