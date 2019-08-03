package Strings;

/*
    A string of length n has n! permutation.

    Below are the permutations of string ABC.
    ABC ACB BAC BCA CBA CAB
 */
public class Permutations {

    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0, str.length() -1);
    }

    /*
        Approach : Backtracking
        Time Complexity: Time Complexity: O(n*n!)
     */

    public static void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                permute(str, start+1, end);
                str = swap(str, start, i);
            }
        }
    }


    public static String swap(String str, int pos1, int pos2) {
        char[] charArray = str.toCharArray();

        char temp = charArray[pos1];
        charArray[pos1] = charArray[pos2];
        charArray[pos2] = temp;

        return String.valueOf(charArray);
    }

}
