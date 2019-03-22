package trie;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/implement-trie-prefix-tree
public class Trie {
    TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("hello");
        t.insert("hell");
        t.insert("world");
        System.out.println(t.search("hell"));
        System.out.println(t.startsWith("hel"));
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        int i = 0;
        for (; i < word.length(); i++) {
            Character c = word.charAt(i);
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        int i = 0;
        for (; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode temp = node.children.get(c);
            if (temp == null) return false;
            node = temp;
        }
        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int i = 0;
        for (; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            TrieNode temp = node.children.get(c);
            if (temp == null) return false;
            node = temp;
        }
        return true;
    }

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }
}
