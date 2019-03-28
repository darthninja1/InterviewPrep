package trie;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
    int prefixCount;
}
