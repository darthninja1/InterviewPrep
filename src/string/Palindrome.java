package string;

import java.util.stream.Stream;

public class Palindrome {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "Nitin", "Blah", "Hoooh", "N i ti n", "A man, a plan, a canal: Panama", "  n i t  i  n  "};
        Stream.of(strings).forEach(s -> System.out.println(s + " -> is" + (isPalindrome(s) ? "" : " not") + " a palindrome"));
    }

    private static boolean isPalindrome(String str) {
        String s = str.toLowerCase();
        if (s == null || s.length() == 1) return true;

        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex < s.length()) {
            char startChar = s.charAt(startIndex);
            char endChar = s.charAt(endIndex);
            if (!Character.isAlphabetic(startChar)) {
                startIndex++;
            } else if (!Character.isAlphabetic(endChar)) {
                endIndex--;
            } else if (startChar != endChar) {
                return false;
            } else {
                ++startIndex;
                --endIndex;
            }
        }
//        if (startIndex == s.length()) return true;
//        return false;
        return true;
    }
}
