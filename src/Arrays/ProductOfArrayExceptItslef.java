package Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptItslef {

    public static void main(String args[]) {
        int[] nums = {1,2,3,4};
        int[] result = productOfArray(nums);
        System.out.println(Arrays.toString(result));

    }
    /*
        Time Complexity O(n)
     */
    public static int[] productOfArray(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] result = new int[length];

        left[0] = 1;
        right[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        for (int j = length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;

    }

}
