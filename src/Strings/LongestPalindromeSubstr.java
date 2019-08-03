package Strings;

public class LongestPalindromeSubstr {

    public static void main(String args[]) {
        String str = "banana";
        System.out.println(longestPalindromeSubstr(str));
        System.out.println(longestPalindrome(str));
    }

    /*
        Brute force solution
        check all substrings of size 1 to n and find maximum

        Time Complexity O(n3)
     */
    public static String longestPalindromeSubstr(String str) {

        int length = str.length();
        int maxLen = 0;
        String maxSubstr = "";
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {

                if (isPalindrome(str.substring(i, j+1))) {
                    if ( (j+1) - i > maxLen) {
                        maxLen = (j+1) - i;
                        maxSubstr = str.substring(i, j+1);
                    }
                }
            }
        }
        return maxSubstr;
    }

    public static boolean isPalindrome(String str) {
        for (int i =0 ; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    /*
        Approach: Dynamic Programming
         Time Complexity : O(n2)

     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }



}

