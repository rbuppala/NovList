package Arrays;

public class MaximumArray {

    public static void main(String args[]) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
        System.out.println(maxSubArrayGreat(array));
    }

    /*
        Time Complexity O(n)
     */
    public static int maxSubArray(int[] array) {
        int maxEndingHere = array[0];
        int maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + array[i], array[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
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
}
