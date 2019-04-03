package array;

// https://www.programcreek.com/2014/08/leetcode-shortest-word-distance-java/
// https://www.geeksforgeeks.org/minimum-distance-between-words-of-a-string/
public class ShortestDistance {
    public static void main(String[] args) {
        System.out.println(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
        System.out.println(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
        System.out.println(shortestDistance(new String[]{"A", "C", "D", "A", "B", "B", "A"}, "A", "B"));
    }

    private static int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int currentDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.equals(word1)) {
                index1 = i;
            } else if (w.equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                currentDistance = Math.min(Math.abs(index1 - index2), currentDistance);
            }
        }
        return currentDistance;
    }
}