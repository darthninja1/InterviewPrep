package string;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRomanNumerals {
    static final TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());

    static {
        treeMap.put(1, "I");
        treeMap.put(4, "IV");
        treeMap.put(5, "V");
        treeMap.put(9, "IX");
        treeMap.put(10, "X");
        treeMap.put(40, "XL");
        treeMap.put(50, "L");
        treeMap.put(90, "XC");
        treeMap.put(100, "C");
        treeMap.put(400, "CD");
        treeMap.put(500, "D");
        treeMap.put(900, "CM");
        treeMap.put(1000, "M");
    }

    public static String intToRoman(int number) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            for (Map.Entry<Integer, String> e : treeMap.entrySet()) {
                if (number >= e.getKey()) {
                    sb.append(e.getValue());
                    number -= e.getKey();
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(123));
        System.out.println(intToRoman(1994));
    }
}
