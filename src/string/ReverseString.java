package string;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("hello".toCharArray()));
        System.out.println(reverse("hell".toCharArray()));
    }

    private static String reverse(char[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (endIndex > startIndex) {
            char temp = arr[endIndex];
            arr[endIndex--] = arr[startIndex];
            arr[startIndex++] = temp;
        }
        return String.valueOf(arr);
    }
}
