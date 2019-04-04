package string;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/unique-morse-code-words/
public class MorseTransformation {
    private static final String[] MORSE_STRINGS = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."};

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    private static int uniqueMorseRepresentations(String[] words) {
        Set<String> morseSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.setLength(0);
            for (int i = 0; i < w.length(); i++) {
                sb.append(MORSE_STRINGS[w.charAt(i) - 'a']);
            }
            morseSet.add(sb.toString());
        }
        return morseSet.size();
    }
}