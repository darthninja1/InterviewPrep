package string;

// https://www.hackerrank.com/challenges/pangrams/problem
public class Pangram {
    public static void main(String[] args) {
        System.out.println(pangram("hello"));
        System.out.println(pangram("We promptly judged antique ivory buckles for the prize"));
        System.out.println(pangram("We promptly judged antique ivory buckles for the next prize"));
    }

    static String pangram(String s) {
        if (s == null || s.length() < 26) {
            return "not pangram";
        }
        int[] chars = new int[26];
        char[] s1 = s.toLowerCase().toCharArray();
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == ' ') {
                continue;
            }
            chars[s1[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) {
                return "not pangram";
            }
        }
        return "pangram";
    }
}
