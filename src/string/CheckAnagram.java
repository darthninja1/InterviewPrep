package string;

// https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
public class CheckAnagram {
    public static void main(String[] args) {
        CheckAnagram c = new CheckAnagram();
        System.out.println(c.check("abcd", "dabc"));
        System.out.println(c.check("iitnn", "nitin"));
        System.out.println(c.check("abcd", "dabcd"));
        System.out.println(c.check("abcd", "debc"));
    }

    private boolean check(String str1, String str2) {
        int[] charStatus = new int[26];
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            charStatus[str1.charAt(i) - 'a']++;
            charStatus[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < charStatus.length; i++) {
            if (charStatus[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
