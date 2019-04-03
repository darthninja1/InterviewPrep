package string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("abcd", "zzzz"));
        System.out.println(isIsomorphic("zzzz", "abcd"));
        System.out.println(isIsomorphic("abcd", "abcd"));
        System.out.println(isIsomorphic("wxyz", "abcd"));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            }
            if (reverseMap.containsKey(c2)) {
                if (reverseMap.get(c2) != c1) {
                    return false;
                }
            }
            map.put(c1, c2);
            reverseMap.put(c2, c1);
        }
        return true;
    }
}