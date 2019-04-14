package string;

// https://leetcode.com/problems/reverse-vowels-of-a-string
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
        System.out.println(reverse("leetcode"));
        System.out.println(reverse("aA"));
    }

    private static String reverse(String s) {
        char[] arr = s.toCharArray();
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (endIndex > startIndex) {
            if (!isVowel(arr[endIndex])) {
                endIndex--;
            } else if (!isVowel(arr[startIndex])) {
                startIndex++;
            } else {
                char temp = arr[endIndex];
                arr[endIndex--] = arr[startIndex];
                arr[startIndex++] = temp;
            }
        }
        return String.valueOf(arr);
    }

    private static boolean isVowel(char c) {
        return (c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'i' || c == 'I'
                || c == 'o' || c == 'O'
                || c == 'u' || c == 'U');
    }
}