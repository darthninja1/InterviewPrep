package trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
    int prefixCount;

    // Only used for finding positions of words
    List<Integer> positions = new ArrayList<>();
}
