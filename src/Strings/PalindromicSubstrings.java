package Strings;

/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstrings {

    public static void main(String args[]) {
        String str = "aaa";
        System.out.println(countSubstrings(str));
        System.out.println(countSubstringsDP(str));
    }
    public static int countSubstrings(String s) {
        int n = s.length();
        int noOfPalindromes = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (isPalindrome(s.substring(i, j))) {
                    noOfPalindromes++;
                }
            }
        }
        return noOfPalindromes;
    }

    private static boolean isPalindrome(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i -1)) {
                return false;
            }
        }
        return true;
    }


    public static int countSubstringsDP(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }


}
