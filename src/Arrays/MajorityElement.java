package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {

    public static void main(String args[]) {
        int[] nums = {1,2,2,3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementMap(nums));
        System.out.println(majorityElementSort(nums));
    }
    /*
            Time Complexity O(n2)
     */
    public static int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;

            for(int elem: nums) {
                if (num == elem) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }

    /*
        Time Complexity O(n)
     */
    public static int majorityElementMap(int[] nums) {
        int majorityCount = nums.length / 2;
        Map.Entry<Integer, Integer> majorityEntry = null;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
        }

        Set<Map.Entry<Integer,Integer>> entries =  countMap.entrySet();

        for(Map.Entry<Integer, Integer> entry: entries) {

            if (entry.getValue() > majorityCount) {
                //System.out.println("..."+entry.getKey()+ "...value"+ entry.getValue());
                majorityEntry = entry;
            }
        }
        return majorityEntry == null ? -1 : majorityEntry.getKey();
    }

    /*
        Time Complexity O(n log n)
     */
    public static int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums.length / 2;
    }
}
