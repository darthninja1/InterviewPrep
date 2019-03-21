package string;

// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
// https://www.topcoder.com/blog/generating-permutations/
public class GenerateAllPermutations {
    public static void main(String[] args) {
        String s = "abc";
        allPermutations(s, 0);
        System.out.println();
        allPermutations2("", s);
    }

    private static void allPermutations(String s, int index) {
        if (index == s.length() - 1) {
            System.out.print(s + " ");
        } else {
            for (int i = index; i < s.length(); i++) {
                String s1 = swap(s, index, i);
                allPermutations(s1, index + 1);
                swap(s1, index, i);
            }
        }
    }

    private static String swap(String s, int index1, int index2) {
        char[] array = s.toCharArray();
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return String.valueOf(array);
    }

    private static void allPermutations2(String prefix, String suffix) {
        if (suffix.length() == 0) {
            System.out.print(prefix + suffix + " ");
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                allPermutations2(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1));
            }
        }
    }
}
