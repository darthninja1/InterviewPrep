package string;

// https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/
// https://www.techiedelight.com/remove-adjacent-duplicates-characters-string/
public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDupes("aabcdabaaccddbeda"));
        System.out.println(removeDupes("AAABBCCDDDEFGH"));

        System.out.println(removeDupes("aabcdabaaccddbeda".toCharArray()));
        System.out.println(removeDupes("AAABBCCDDDEFGH".toCharArray()));
    }

    private static String removeDupes(String s) {
        StringBuilder sb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        while (index1 < s.length()) {
            while (index2 < s.length() && s.charAt(index1) == s.charAt(index2)) {
                index2++;
            }
            sb.append(s.charAt(index1));
            index1 = index2;
        }
        return sb.toString();
    }

    private static int removeDupes(char[] arr) {
        int index1 = 0;
        int index2 = 0;
        int writeIndex = 0;
        while (index1 < arr.length) {
            while (index2 < arr.length && arr[index1] == arr[index2]) {
                index2++;
            }
            arr[writeIndex++] = arr[index1];
            index1 = index2;
        }
        return writeIndex;
    }
}
