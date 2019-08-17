package Arrays;

/*
    Count triplets with sum smaller than a given value

    Given an array of distinct integers and a sum value.
    Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2)

    Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
    Output : 2
    Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3)
 */
public class CountTriplets {

    public static void main(String args[]) {
        int[] array = {-2, 0, 1, 3};
        System.out.println("count of triplets "+ countTriplets(array,2));
    }
    /*
        A Simple Solution is to run three loops to consider all triplets one by one.
        For every triplet, compare the sums and increment count if triplet sum is smaller than given sum.
     */
    public static int countTriplets(int[] array, int sum) {
        int ans = 0;
        int length = array.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if ((array[i] + array[j]+ array[k]) < sum){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
