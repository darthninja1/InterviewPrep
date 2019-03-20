package string;

// https://algs4.cs.princeton.edu/53substring/Brute.java.html
public class IsSubstring {
    public static void main(String[] args) {
        System.out.println(isSubstring("abc", "aabdcde"));
        System.out.println(isSubstring2("abc", "aabdcde"));
        System.out.println(isSubstring("abc", "aabcdde"));
        System.out.println(isSubstring2("abc", "aabcdde"));
        System.out.println(isSubstring("  ", "ss  fgtg"));
        System.out.println(isSubstring2("  ", "ss  fgtg"));
        System.out.println(isSubstring(",,,", "  fgtg,,,"));
        System.out.println(isSubstring2(",,,", "  fgtg,,,"));
    }

    // Brute force
    static boolean isSubstring(String pattern, String text) {
        if (text == null || text.length() == 0) return false;
        int patIndex = 0;
        int txtIndex = 0;
        int txtLen = text.length();
        int patLen = pattern.length();
        while (txtIndex < txtLen && patIndex < patLen) {
            if (pattern.charAt(patIndex) == text.charAt(txtIndex)) {
                patIndex++;
                txtIndex++;
            } else {
                txtIndex = txtIndex - patIndex + 1; // backtrack to patIndex characters and add 1
                patIndex = 0;
            }
        }
        return patIndex == pattern.length();
    }

    // Brute force
    static boolean isSubstring2(String pattern, String text) {
        if (text == null || text.length() == 0) return false;
        int txtLen = text.length();
        int patLen = pattern.length();
        // Only loop till txtLen - patLen because after that there aren't
        // enough characters to match
        for (int txtIndex = 0; txtIndex <= txtLen - patLen; txtIndex++) {
            int patIndex;
            for (patIndex = 0; patIndex < patLen; patIndex++) {
                if (pattern.charAt(patIndex) != text.charAt(txtIndex + patIndex)) {
                    break;
                }
            }
            if (patIndex == patLen) return true;
        }
        return false;
    }
}
