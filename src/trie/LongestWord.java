package trie;

// https://leetcode.com/problems/longest-word-in-dictionary/
public class LongestWord {

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(longestWord(new String[]{"a", "bananas", "app", "appl", "ap", "apply", "apple", "apples"}));
    }

    private static String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        return longestWord(trie.getRoot());
    }

    private static String longestWord(TrieNode root) {
        String max = "";
        for (int i = 0; i < root.children.length; i++) {
            TrieNode c = root.children[i];
            if (c == null || !c.isWord) continue;
            String s = (char) ('a' + i) + longestWord(c);
            if (s.length() > max.length()) {
                max = s;
            }
        }
        return max;
    }
}