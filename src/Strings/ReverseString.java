package Strings;

/*
344. Reverse String
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

 */
public class ReverseString {

    public static void main(String args[]) {
        String str = "Ramana";
        char[] word = str.toCharArray();
        reverseStr(word);
        System.out.println(reverseString(str));
        System.out.println(reversStrLoop(str));
    }

    /*
        Time Complexity O(n)
        Approach: Iterative Swapping Using Two Pointers
     */
    public static void reverseStr(char[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        System.out.println(new String(array));

    }
    /*
        Time Complexity : O(n log(n))

        Approach: Divide and Conquer (Recursive)
        The string is split into half. Each substring will be further divided.
        This process continues until the string can no longer be divided (length `)
     */
    public static String reverseString(String str) {
        int length = str.length();

        if (length <= 1) return str;

        String leftStr = str.substring(0, length / 2);
        String rightStr = str.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);

    }

    /*
        Time Complexity O(n)
     */
    public static String reversStrLoop(String str) {
        StringBuffer newStr = new StringBuffer();

        for (int i = str.length() -1; i >= 0; i--) {
            newStr.append(str.charAt(i));
        }
        return newStr.toString();
    }
}
