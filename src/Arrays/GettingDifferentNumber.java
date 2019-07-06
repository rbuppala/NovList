package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
    Given an array arr of unique nonnegative integers,
     implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.
 */
public class GettingDifferentNumber {

    public static void main(String args[]) {
        int[] nums = {0,1,3,4};
        System.out.println(getDifferentNumberBruteForce(nums));
        System.out.println(getDifferentNumberSet(nums));
    }


    /*
        Time Complexity O(n log n)
     */
    public static int getDifferentNumberBruteForce(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i]) {
                return i;
            }
        }
        return length;
    }
    /*
        Time Complexity O(n)
        Space Complexity O(n)
     */
    public static int getDifferentNumberSet(int[] arr) {
        int length = arr.length;
        Set<Integer> numsSet = new HashSet<>();

        for (Integer num: arr) {
            numsSet.add(num);
        }

        for (int i = 0; i < arr.length; i++) {
            if(!numsSet.contains(i)) {
                return i;
            }
        }
        return length;
    }
}
