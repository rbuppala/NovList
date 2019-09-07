package Arrays;

/*
    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDuplicates {

    public static void main(String args[]) {
        int[] array = {1,1,2};
        System.out.println("Array length:"+arrayLength(array));
    }

    /*
        Time Complexity O(n)
        Space Complexity O(1)
     */
    private static int arrayLength(int[] array) {
        int i = 0;

        for (int j = 1; j < array.length; j++) {
            if (array[i] != array[j]) {
                i += 1;
            }
            array[i] = array[j];
        }

        return i + 1;
    }
}
