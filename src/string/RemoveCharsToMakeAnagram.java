package string;

// https://www.geeksforgeeks.org/remove-minimum-number-characters-two-strings-become-anagram/
public class RemoveCharsToMakeAnagram {
    public static void main(String[] args) {
        RemoveCharsToMakeAnagram c = new RemoveCharsToMakeAnagram();
        System.out.println(c.check("abcd", "dabc"));
        System.out.println(c.check("abcd", "dabcd"));
        System.out.println(c.check("abcd", "debc"));
        System.out.println(c.check("iitnn", "nitin"));
        System.out.println(c.check("iitn", "abcd"));
    }

    private int check(String str1, String str2) {
        int[] charStatus = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            charStatus[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            charStatus[str2.charAt(i) - 'a']--;
        }
        int sum = 0;
        for (int i = 0; i < charStatus.length; i++) {
            sum += Math.abs(charStatus[i]);
        }
        return sum;
    }
}
