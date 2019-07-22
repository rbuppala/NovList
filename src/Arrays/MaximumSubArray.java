package Arrays;

/*
 Maximum Subarray

 Given an integer array nums, find the contiguous subarray (containing at least one number)
 which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

 */
public class MaximumSubArray {

    public static void main(String args[]) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
        System.out.println(maxSubArrayGreat(array));
        System.out.println(maxSubArray1(array));
    }

    /*
        Time Complexity O(n)
        Kadane's algorithm

        Initialize:
        max_so_far = 0
        max_ending_here = 0

        Loop for each element of the array
          (a) max_ending_here = max_ending_here + a[i]
          (b) if(max_ending_here < 0)
                    max_ending_here = 0
          (c) if(max_so_far < max_ending_here)
                    max_so_far = max_ending_here
        return max_so_far
     */
    public static int maxSubArray(int[] array) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int i = 0; i < array.length; i++) {
            maxEndingHere = maxEndingHere + array[i];

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

        }
        return maxSoFar;
    }

    /*
        Time Complexity O(n)
     */
    public static int maxSubArrayGreat(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static int maxSubArray1(int[] array) {
        int max = array[0];
        int current = array[0];

        for (int i = 1; i < array.length; i++) {
            current = Math.max(array[i], current + array[i]);
            if (max < current) max = current;
        }
        return max;
    }
}
