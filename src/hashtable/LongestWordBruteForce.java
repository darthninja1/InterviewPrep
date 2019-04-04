package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-word-in-dictionary/
// See trie solution for optimized solution
public class LongestWordBruteForce {
    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(longestWord(new String[]{"a", "bananas", "app", "appl", "ap", "apply", "apple"}));
    }

    private static String longestWord(String[] dict) {
        Set<String> dictSet = new HashSet<>(Arrays.asList(dict));
        int max = 0;
        String maxStr = "";
        for (String w : dict) {
            int len = 0;
            int i = 0;
            for (; i < w.length(); i++) {
                if (dictSet.contains(w.substring(0, i + 1))) {
                    len++;
                } else {
                    break;
                }
            }
            if (i == w.length()) {
                if (len > max) {
                    max = len;
                    maxStr = w;
                } else if (len == max) {
                    // check lex order
                    if (w.compareTo(maxStr) < 0) {
                        maxStr = w;
                    }
                }
            }
        }
        return maxStr;
    }

}
