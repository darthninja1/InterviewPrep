package string;

import java.util.*;

/*
Given a dictionary and a string, write a function longestAnagram() that returns the longest anagrams
of the input string present in the dictionary.
 */
public class AnagramWithRepetitions {
    public static void main(String[] args) {
        List<String> testString = new ArrayList<>();
        testString.add("ad");
        testString.add("DAddske");
        testString.add("gdslels");
        testString.add("Daund");
        testString.add("edlsjf");
        testString.add("UDAadunnnD");
        if (longestAnagram("Daund", testString).equalsIgnoreCase("UDAadunnnD")) {
            System.out.println("Test Passed");
        }
        testString.clear();
        testString.add("dis");
        testString.add("siSisis");
        testString.add("dddddddDDDD");
        testString.add("disSidDIS");
        testString.add("si");
        if (longestAnagram("Sid", testString).equalsIgnoreCase("disSidDIS")) {
            System.out.println("Test2 Passed");
        } else
            System.out.println("Test Failed");
    }

    private static String longestAnagram(String s, List<String> dict) {
        if (s == null) return "Error";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(Character.toLowerCase(s.charAt(i)));
        }
        List<String> candidates = new ArrayList<>();
        for (String str : dict) {
            Set<Character> charSet = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                charSet.add(Character.toLowerCase(str.charAt(i)));
            }
            if (set.equals(charSet)) {
                candidates.add(str);
            }
        }
        return candidates.stream().max(Comparator.comparingInt(String::length)).orElse("");
    }
}