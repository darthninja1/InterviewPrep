package string;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
public class LongestUniqueSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabcdde"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("  "));
        System.out.println(lengthOfLongestSubstring(",,*(2e$,"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] array = s.toCharArray();
        int[] charCount = new int[256];
        int maxLength = 1;
        int currentLength = 1;
        int startIndex = 0;
        int endIndex = 1;
        charCount[array[startIndex]] = 1;
        while (endIndex < array.length && startIndex < array.length) {
            char endChar = array[endIndex];
            if (charCount[endChar] == 0) {
                charCount[endChar] = 1;
                endIndex++;
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } else {
                charCount[array[startIndex]]--;
                startIndex++;
                currentLength--;
            }
        }
        return maxLength;
    }
}