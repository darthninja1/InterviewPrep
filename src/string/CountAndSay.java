package string;

// https://leetcode.com/problems/count-and-say/
public class CountAndSay {
    public static void main(String[] args) {
        countAndSay(10);
    }

    private static String countAndSay(int n) {
        String number = "1";
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            System.out.println(number);
            int count = 1;
            for (int i = 1; i < number.length(); i++) {
                if (number.charAt(i) == number.charAt(i - 1)) {
                    count++;
                } else {
                    sb.append(count).append(number.charAt(i - 1));
                    count = 1;
                }
            }
            sb.append(count).append(number.charAt(number.length() - 1));
            number = sb.toString();
            sb.setLength(0);
        }
        return number;
    }
}