package Strings;

/*
Given a string, you need to reverse the order of characters in each word
within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWords {

    public static void main(String args[]) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String str) {
        StringBuffer newString = new StringBuffer();
        String[] words = str.split(" ");

        for (String word: words) {
            newString.append(reverse(word))
                    .append(" ");
        }
        return newString.toString();
    }

    public static String reverse(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        int j;

        for (int i = 0; i < length; i++) {
            j = str.length() - i - 1;
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return String.valueOf(charArray);
    }
}
