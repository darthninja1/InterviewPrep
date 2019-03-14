package string;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class FirstRecurringChar {
    public static void main(String[] args) {
        List<String> inputs = Lists.newArrayList("abba", "abca", "bcaba", "abc", "dbcaba");
        inputs.forEach(i -> System.out.println(i + ": " + isRecurring(i)));
    }

    private static String isRecurring(String i) {
        Set<Character> chars = Sets.newHashSet();
        for (Character c : i.toCharArray()) {
            if (chars.contains(c)) {
                return String.valueOf(c);
            } else {
                chars.add(c);
            }
        }
        return null;
    }
}


