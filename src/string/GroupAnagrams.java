package string;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"toe", "cat", "dog", "god", "eot", "eat",
                "tea", "tan", "ate", "nat", "bat"}));
    }

    private static List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : arr) {
            int[] chars = new int[26];
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
            }
            String sorted = Arrays.toString(chars);
            List<String> list = groups.computeIfAbsent(sorted, k -> new ArrayList<>());
            list.add(s);
        }
        return new ArrayList<>(groups.values());
    }
}