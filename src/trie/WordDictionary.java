package trie;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/
public class WordDictionary {
    TrieNode root = new TrieNode();

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (word.charAt(index) != '.') {
            int offset = word.charAt(index) - 'a';
            TrieNode temp = node.children[offset];
            if (temp == null) return false;
            return searchHelper(temp, word, index + 1);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (searchHelper(node.children[i], word, index + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        dict.addWord("man");
        System.out.println(dict.search("pad"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search(".ad"));
        System.out.println(dict.search(".an"));
        System.out.println(dict.search(".a."));
        System.out.println(dict.search(".a.."));
    }
}