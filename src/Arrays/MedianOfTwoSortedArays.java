package Arrays;

import java.util.Arrays;

/*
    here are two sorted arrays nums1 and nums2 of size m and n respectively.

    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

    You may assume nums1 and nums2 cannot be both empty.

    Example 1:

    nums1 = [1, 3]
    nums2 = [2]

    The median is 2.0
    Example 2:

    nums1 = [1, 2]
    nums2 = [3, 4]

    The median is (2 + 3)/2 = 2.5

    Median” is “middle” value in list of numbers. To find median, input should be sorted from smallest to largest.
    If input is not sorted, then we have to first sort and them return middle of that list.
    Question arises is what if number of elements in list are even? In that case, median is average of two middle elements
 */
public class MedianOfTwoSortedArays {

    public static void main(String args[]) {
        int[] array1 = {1,2};
        int[] array2 = {3,4};
        System.out.println(findMedian(array1,array2));
    }

    /*
        Time Complexity O(n)
     */
    public static double findMedian(int[] array1, int[] array2) {
        int i = 0, j = 0, k = 0;
        int lenA = array1.length;
        int lenB = array2.length;
        int[] result = new int [lenA + lenB];

        while (i < lenA && j < lenB) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }
        while (i < lenA) {
            result[k++] = array1[i++];
        }

        while (j < lenB) {
            result[k++] = array2[j++];
        }

        int length = result.length;
        if (length % 2 == 0) {
            return (result[length / 2 - 1] + result[length / 2]) / 2.0;
        }
        return result[length / 2];
    }
}
