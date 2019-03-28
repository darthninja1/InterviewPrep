package string;

import com.google.common.base.Joiner;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDupes("interview prep"));
        System.out.println(removeDupes2("interview prep"));
    }

    private static String removeDupes(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String removeDupes2(String s) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            }
        }
        return Joiner.on("").join(set);
    }
}
