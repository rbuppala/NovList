package Strings;

public class LongestPalindromeSubstr {

    public static void main(String args[]) {
        String str = "bananas";
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
    public static String longestPalindrome(String str) {
        int length = str.length();

        if (str == null || length < 2) {
            return str;
        }

        boolean[][] isPalindrome = new boolean[length][length];

        int left = 0;
        int right = 0;

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerPalindrome = isPalindrome[i+1][j-1] || (j - i) <= 2;
                if (str.charAt(i) == str.charAt(j) && isInnerPalindrome) {
                    isPalindrome[i][j] = true;

                    if ( j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return str.substring(left, right + 1);
    }



}

