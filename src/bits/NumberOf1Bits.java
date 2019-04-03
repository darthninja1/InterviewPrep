package bits;

// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    public static void main(String[] args) {
        hammingWeight(0xFFFF);
        hammingWeight(0);
        hammingWeight(0xFFFFFFFF);
        hammingWeight(0xAA);
        hammingWeight(11);
    }

    private static void hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        System.out.println(Integer.toBinaryString(n) + " -> " + count);
    }

}