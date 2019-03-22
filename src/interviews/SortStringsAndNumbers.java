package interviews;

import java.util.*;

// https://github.com/rajanmalhotra/Code-Samples/blob/master/twosigma/ReadMe
public class SortStringsAndNumbers {
    public static void main(String[] args) {
        System.out.println("Sorted  : " + sort("car truck 8 4 bus 6 1"));
        System.out.println("Sorted  : " + sort1("8 4 6 1 -2 9 5"));
    }

    private static String sort(String s) {
        System.out.println("Original: " + s);
        StringBuilder sb = new StringBuilder();
        String[] original = s.split(" ");
        String[] sortedArray = Arrays.copyOf(original, original.length);
        Arrays.sort(sortedArray);
        int numIndex = 0;
        int wordIndex = 0;
        BitSet bitSet = new BitSet();
        for (int i = 0; i < sortedArray.length; i++) {
            if (Character.isDigit(sortedArray[i].charAt(0)) || sortedArray[i].charAt(0) == '-' && Character.isDigit(sortedArray[i].charAt(1))) {
                wordIndex++;
            }
            if (Character.isDigit(original[i].charAt(0)) || original[i].charAt(0) == '-' && Character.isDigit(original[i].charAt(1))) {
                bitSet.set(i);
            }
        }
        for (int i = 0; i < original.length; i++) {
            if (bitSet.get(i)) {
                sb.append(sortedArray[numIndex++]).append(" ");
            } else {
                sb.append(sortedArray[wordIndex++]).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private static String sort1(String s) {
        System.out.println("Original: " + s);
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<String> entries = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);
        BitSet bitSet = new BitSet();
        int index = 0;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            entries.add(token);
            if (Character.isAlphabetic(token.charAt(0))) {
                bitSet.set(index);
                words.add(token);
            } else {
                numbers.add(Integer.valueOf(token));
            }
            index++;
        }
        Collections.sort(words);
        Collections.sort(numbers);
        int wordIndex = 0;
        int numIndex = 0;
        for (int i = 0; i < entries.size(); i++) {
            if (bitSet.get(i)) {
                sb.append(words.get(wordIndex++)).append(" ");
            } else {
                sb.append(numbers.get(numIndex++)).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
