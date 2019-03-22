package trie;

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
        System.out.println(t.startsWith("ho"));
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        int i = 0;
        for (; i < word.length(); i++) {
            int offset = word.charAt(i) - 'a';
            TrieNode temp = node.children[offset];
            if (temp == null) {
                temp = new TrieNode();
                node.children[offset] = temp;
            }
            node = temp;
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
            int offset = word.charAt(i) - 'a';
            TrieNode temp = node.children[offset];
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
            int offset = prefix.charAt(i) - 'a';
            TrieNode temp = node.children[offset];
            if (temp == null) return false;
            node = temp;
        }
        return true;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}
