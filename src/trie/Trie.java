package trie;

// https://leetcode.com/problems/implement-trie-prefix-tree
public class Trie {
    TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Trie t = new Trie();
        String[] wordsForInsert = {"she", "sells", "sea", "shore",
                "know", "knowledge", "knowledges", "knowledgement"};
        for (String word : wordsForInsert) {
            t.insert(word);
        }
        System.out.println(t.search("sells"));
        System.out.println(t.startsWith("se"));
        System.out.println(t.startsWith("k"));
        System.out.println(t.startsWith("knowledge"));
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
            node.prefixCount++;
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
     * Returns count of words in the trie that starts with the given prefix.
     */
    public int startsWith(String prefix) {
        TrieNode node = root;
        int i = 0;
        for (; i < prefix.length(); i++) {
            int offset = prefix.charAt(i) - 'a';
            TrieNode temp = node.children[offset];
            if (temp == null) return 0;
            node = temp;
        }
        return node.prefixCount;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        int prefixCount;
    }
}
