package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {
    public static void main(String args[]) {
        int[] array = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(array, 9)));
        System.out.println(Arrays.toString(twoSumMap(array, 9)));
    }
    /*
        Time Complexity O(n2)
     */
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = i +1 ; j < length; j++) {
                if (nums[i]+ nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /*
        Time Complexity O(n)
     */
    public static int[] twoSumMap(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) return new int[] {0,0};

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                result[0] = numsMap.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                numsMap.put(nums[i], i);
            }
        }
        return result;
    }
    
}
