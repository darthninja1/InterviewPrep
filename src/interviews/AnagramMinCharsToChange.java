package interviews;

/*
We define an anagram to be a word whose characters can be rearranged to create another word. Given two strings, we want to know the minimum number of characters in either string that we must modify to make the two strings anagrams. If it's not possible to make the two strings anagrams, we consider this number to be -1.

For example:
- tea and ate are anagrams, so we would need to modify 0 characters.
- tea and toe are not anagrams, but we can modify 1 character in either string (o -> a or a -> o) to make them anagrams.
- act and acts are not anagrams and cannot be converted to anagrams because they contain different numbers of characters. 

Requirements:
Write a function to return minimum number of characters in two strings that need to be modified to make the two strings anagrams. If it's not possible, return -1.
 */

class AnagramMinCharsToChange {
    public static void main(String[] args) {
        System.out.println(minChars("toe", "tea"));
        System.out.println(minChars("nitin", "iitnn"));
        System.out.println(minChars("hello", "hallo"));
        System.out.println(minChars("toe", "teaa"));
        System.out.println(minChars("toe", ""));
        System.out.println(minChars("toe", null));
        System.out.println(minChars(null, null));
        System.out.println(minChars("", ""));
    }

    private static int minChars(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s1 == null || s2 == null) {
            return -1;
        }
        if (s1.length() != s2.length()) {
            return -1;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }

        // System.out.println(Arrays.toString(count));

        for (int i = 0; i < s2.length(); i++) {
            if (count[s2.charAt(i) - 'a'] > 0) {
                count[s2.charAt(i) - 'a'] = count[s2.charAt(i) - 'a'] - 1;
            }
        }
        // System.out.println(Arrays.toString(count));

        int minCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                minCount++;
            }
        }
        return minCount;
    }
}