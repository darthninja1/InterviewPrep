package array;

// https://leetcode.com/problems/string-compression
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(new StringCompression().compress("aaaaaabbccc".toCharArray()));
        System.out.println(new StringCompression().compress("aaaaaa".toCharArray()));
        System.out.println(new StringCompression().compress("a".toCharArray()));
        System.out.println(new StringCompression().compress("abcd".toCharArray()));
    }

    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;
        int charStartindex = 0;
        int count = 0;
        int len = chars.length;
        while (readIndex < len) {
            // read past all matching chars
            while (readIndex < len && chars[readIndex] == chars[charStartindex]) {
                count++;
                readIndex++;
            }
            // copy matched char to write index
            chars[writeIndex++] = chars[charStartindex];
            charStartindex = readIndex;
            if (count != 1) { // if count > 1, write that too
                String tempCountVal = String.valueOf(count);
                for (char t : tempCountVal.toCharArray())
                    chars[writeIndex++] = t;
            }
            count = 0;
        }
        // clear out remaining chars
        int i = writeIndex;
        while (i < len) {
            chars[i++] = 0;
        }
        return writeIndex;
    }
}
