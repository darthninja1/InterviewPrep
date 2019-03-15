package recursive;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashSet;
import java.util.stream.Collectors;

public class MorseConverter {
    static BiMap<String, String> MAPPINGS = HashBiMap.create();
    static BiMap<String, String> REVERSE_MAPPINGS = MAPPINGS.inverse();
    static HashSet<String> data = new HashSet<>();

    static {
        MAPPINGS.put("0", "-----");
        MAPPINGS.put("1", ".----");
        MAPPINGS.put("2", "..---");
        MAPPINGS.put("3", "...--");
        MAPPINGS.put("4", "....-");
        MAPPINGS.put("5", ".....");
        MAPPINGS.put("6", "-....");
        MAPPINGS.put("7", "--...");
        MAPPINGS.put("8", "---..");
        MAPPINGS.put("9", "----.");
        MAPPINGS.put("A", ".-");
        MAPPINGS.put("B", "-...");
        MAPPINGS.put("C", "-.-.");
        MAPPINGS.put("D", "-..");
        MAPPINGS.put("E", ".");
        MAPPINGS.put("F", "..-.");
        MAPPINGS.put("G", "--.");
        MAPPINGS.put("H", "....");
        MAPPINGS.put("I", "..");
        MAPPINGS.put("J", ".---");
        MAPPINGS.put("K", "-.-");
        MAPPINGS.put("L", ".-..");
        MAPPINGS.put("M", "--");
        MAPPINGS.put("N", "-.");
        MAPPINGS.put("O", "---");
        MAPPINGS.put("P", ".--.");
        MAPPINGS.put("Q", "--.-");
        MAPPINGS.put("R", ".-.");
        MAPPINGS.put("S", "...");
        MAPPINGS.put("T", "-");
        MAPPINGS.put("U", "..-");
        MAPPINGS.put("V", "...-");
        MAPPINGS.put("W", ".--");
        MAPPINGS.put("X", "-..-");
        MAPPINGS.put("Y", "-.--");
        MAPPINGS.put("Z", "--..");
    }

    public static void main(String[] args) {
        String text = "SMASH".chars().mapToObj(c -> MAPPINGS.get(Character.toString((char) c))).collect(Collectors.joining());
        System.out.println(text);
        convertToText(text, 0, "");
        System.out.println(data);
        System.out.println("It contains SMASH: " + data.contains("SMASH"));

        data.clear();
        String morse = ".-..";
        convertToText(morse, 0, "");
        System.out.println(data);

        data.clear();
        morse = "..-..";
        convertToText(morse, 0, "");
        System.out.println(data);
    }

    private static void convertToText(String morse, int index, String outputString) {
        if (index == morse.length()) {
            data.add(outputString);
            return;
        }
        recurse(morse, index, index + 1, outputString);
        recurse(morse, index, index + 2, outputString);
        recurse(morse, index, index + 3, outputString);
        recurse(morse, index, index + 4, outputString);
        recurse(morse, index, index + 5, outputString);
    }

    private static void recurse(String morseText, int startIndex, int endIndex, String outputString) {
        if (endIndex <= morseText.length()) {
            String subStr = REVERSE_MAPPINGS.get(morseText.substring(startIndex, endIndex));
            if (null != subStr) {
                convertToText(morseText, endIndex, outputString + subStr);
            }
        }
    }
}