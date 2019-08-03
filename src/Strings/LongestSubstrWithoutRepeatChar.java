package Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutRepeatChar {


    public static void main(String args[]) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstringSliding(str));
    }
    /*
        Brute Force
        Iterate through all the possible substrings of the given string s
        and call the function allUnique to see if they are unique

        Time complexity : O(n^3)
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s.substring(i,j))) {
                    max = Math.max(max, (j - i));
                }
            }
        }
        return max;

    }

    public static boolean allUnique(String str) {
        Set<Character> charSet = new HashSet<>();
        char[] charArray = str.toCharArray();

        for (Character ch: charArray) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        return true;
    }


    /*
        Approach: Sliding Window
        Time Complexity O(n)
     */

    public static int lengthOfLongestSubstringSliding(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }
}
