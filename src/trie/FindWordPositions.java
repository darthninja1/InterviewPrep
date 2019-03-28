package trie;

// http://www.ardendertat.com/2011/12/20/programming-interview-questions-23-find-word-positions-in-text/
public class FindWordPositions {

    public static void main(String[] args) {
        String str = "us use uses used user users using useful username user utah";
        Trie trieRoot = new Trie();
        int i = 0;
        for (String s : str.split("\\s")) {
            TrieNode t = trieRoot.insert(s);
            t.positions.add(i++);
        }
        System.out.println(trieRoot.getNode("user").positions);
    }
}
