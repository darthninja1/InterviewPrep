package string;

import java.util.HashMap;
import java.util.Map;

// https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
public class LongestSubstringKUnique {
    public static void main(String[] args) {
        System.out.println(longest("aaabcaabbbbccccbbbbeeeeebbbbebeb", 2));
        System.out.println(longest("abcbbbbcccbdddadacb", 2));
        System.out.println(longest("ab", 2));
        System.out.println(longest("ab", 10));
    }

    private static String longest(String s, int k) {
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            if (map.size() <= k) {
                if (end - start + 1 > max) {
                    maxStart = start;
                    maxEnd = end + 1;
                    max = end - start + 1;
                }
            } else {
                while (map.size() > k) {
                    char c = s.charAt(start);
                    int count = map.get(c);
                    if (count > 1) {
                        map.put(c, count - 1);
                    } else {
                        map.remove(c);
                    }
                    start++;
                }
            }
            end++;
        }
        return s.substring(maxStart, maxEnd);
    }
}
