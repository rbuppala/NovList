package Arrays;

/*
    Find Peak Element

    A peak element is an element that is greater than its neighbors.

    Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

    The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

    Example 1:

    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.
    Example 2:

    Input: nums = [1,2,1,3,5,6,4]
    Output: 1 or 5
    Explanation: Your function can return either index number 1 where the peak element is 2,
                 or index number 5 where the peak element is 6.

    Case 1. All the numbers appear in a descending order.  In this case, the first element corresponds to the peak element.
    Case 2. All the elements appear in ascending order.. In this case, the last element corresponds to the peak element.
    Case 3. The peak appears somewhere in the middle

   */
public class PeakElement {
    public static void main(String args[]) {
        int[] ascArray = {1,2,3};
        int[] descArray = {3,2,1};
        int[] peakInMiddle = {1,2,4,2,9};
        System.out.println(peakElement(ascArray));
        System.out.println(peakElement(descArray));
        System.out.println(peakElement(peakInMiddle));

        System.out.println(peakElementBinarySearch(peakInMiddle));
    }
    /*
      Complexity Analysis

      Time complexity : O(n) We traverse the nums array of size nn once only.

      Space complexity : O(1) Constant extra space is used.
     */
    public static int peakElement(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            if (array[i] > array[i + 1]) {
                return i;
            }
        }
        return array.length - 1;
    }

    /*
        Time Complexity O(log n)
     */
    public static int peakElementBinarySearch(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while (low < high) {
            mid = (low + high) / 2;
            if (array[mid] < array[mid+1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
