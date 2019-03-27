package string;

import com.google.common.collect.Lists;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        List<String> inputs = Lists.newArrayList("abba", "abca", "bcaba", "abc", "dbcaba");
        inputs.forEach(i -> System.out.println(i + ": " + firstUnique(i)));
    }

    private static Character firstUnique(String i) {
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (Character c : i.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : chars.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }
        return null;
    }
}
