package Arrays;

import java.util.HashSet;
import java.util.Set;

/*
    Given an array of integers, find if the array contains any duplicates.

    Your function should return true if any value appears at least twice in the array,
    and it should return false if every element is distinct.

    Example 1:

    Input: [1,2,3,1]
    Output: true
    Example 2:

    Input: [1,2,3,4]
    Output: false

 */
public class ContainsDuplicate {

    public static void main(String args[]) {
        int[] array = {1,5,3,6};
        System.out.println(containsDuplicate(array));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (Integer num: nums) {
            if (numsSet.contains(num)) {
                return true;
            } else {
                numsSet.add(num);
            }
        }
        return false;
    }

}
