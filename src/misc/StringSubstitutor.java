package misc;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// X = ABC
// Y = DEF
// %X%_%Y% = ABC_DEF
public class StringSubstitutor {
    private Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        StringSubstitutor s = new StringSubstitutor();

        s.register("X", "ABCDEFGH");
        s.register("Y", "World!");
        System.out.println(s.map);
        System.out.println("%X%_%Y% -> " + s.resolveValue("%X%_%Y%"));
        s.map.clear();

        s.register("A", "1");
        s.register("B", "2");
        s.register("C", "%A%_%B%");
        s.register("D", "%B%_%A%");
        s.register("E", "%C%_%D%");
        System.out.println(s.map);
        System.out.println("%E%_%C% -> " + s.resolveValue("%E%_%C%"));
        s.map.clear();

        s.register("V", "abcd%V%");
        s.register("W", "%Z%_%X%");
        s.register("X", "%Y%**A");
        s.register("Y", "B");
        s.register("Z", "123_%X%_123");
        s.register("W", "%Z%_%X%");
        System.out.println(s.map);
        System.out.println("%X%_%Y% -> " + s.resolveValue("%X%_%Y%"));
        System.out.println("%W%_%Y% -> " + s.resolveValue("%W%_%Y%"));
        s.map.clear();

        List<Pair<String, String>> vars= new ArrayList<>();
        vars.add(Pair.of("V", "abcd%V%"));
        vars.add(Pair.of("W", "%Z%_%X%"));
        vars.add(Pair.of("X", "%Y%**A"));
        vars.add(Pair.of("Y", "B"));
        vars.add(Pair.of("Z", "123_%X%_123"));
        vars.add(Pair.of("W", "%Z%_%X%"));
        s.register(vars);
        System.out.println(s.map);
        System.out.println("%X%_%Y% -> " + s.resolveValue("%X%_%Y%"));
        System.out.println("%W%_%Y% -> " + s.resolveValue("%W%_%Y%"));
    }

    private void register(String varName, String varValue) {
        String processedValue = replaceAll(varValue, map);
//        System.out.println("Orig value: " + varValue + " ,Update value: " + processedValue);
        if (processedValue.contains("%"+varName+"%")) {
            System.out.println("Bad input - var value cannot reference var name");
            return;
        }
        map.put(varName, processedValue);
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put(varName, varValue);
        for (Map.Entry<String, String> e : map.entrySet()) {
            String updated = replaceAll(e.getValue(), tempMap);
            if (!e.getValue().equals(updated)) {
                map.put(e.getKey(), updated);
            }
        }
    }

    private void register(List<Pair<String, String>> vars) {
        for (Pair<String, String> p : vars) {
            String processedValue = replaceAll(p.getValue(), map);
            if (processedValue.contains("%"+p.getKey()+"%")) {
                System.out.println("Bad input - var value cannot reference var name");
                continue;
            }
            map.put(p.getKey(), processedValue);
            Map<String, String> tempMap = new HashMap<>();
            tempMap.put(p.getKey(), processedValue);
            for (Map.Entry<String, String> e : map.entrySet()) {
                String updated = replaceAll(e.getValue(), tempMap);
                if (!e.getValue().equals(updated)) {
                    map.put(e.getKey(), updated);
                }
            }
        }
    }

    private String resolveValue(String value) {
        return replaceAll(value, map);
    }

    private String replaceAll(String value, Map<String, String> map) {
//        System.out.println("Replacing string: " + value);
        int startIndex = 0;
        StringBuilder sb = new StringBuilder(value);
        while (startIndex < sb.length()) {
//            System.out.println("Finding from: " + startIndex);
            Triple<String, Integer, Integer> result = find(sb.toString(), startIndex);
//            System.out.println("Found: " + result);
            if (result.getRight() == -1) {
                return sb.toString();
            }
            String keyValue = map.get(result.getLeft());
            if (keyValue == null || keyValue.equals("")) {
                startIndex = result.getRight() + 1;
                continue;
            }
            int oldLength = result.getRight() - result.getMiddle();
            sb.replace(result.getMiddle(), result.getRight(), keyValue);
            startIndex = result.getRight() + keyValue.length() - oldLength;
        }
        return sb.toString();
    }

    private Triple<String, Integer, Integer> find(String value, int startIndex) {
//        System.out.println("Finding in string: " + value + ", from index: " + startIndex);
        StringBuilder sb = new StringBuilder();
        int index = value.indexOf('%', startIndex);
//        System.out.println("index: " + index);
        if (index != -1 && index < value.length()) {
            startIndex = index;
            index = value.indexOf('%', startIndex + 1);
//            System.out.println("index: " + index);
            if (index != -1) {
                sb.append(value, startIndex + 1, index);
            } else {
                // Found a single %
                return Triple.of("", startIndex, -1);
            }
        } else {
            // No % found
            return Triple.of("", -1, -1);
        }
        return Triple.of(sb.toString(), startIndex, index + 1);
    }
}