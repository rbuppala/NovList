import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumberArray {

    public static void main(String args[]) {
        int[] array = {1,2,3,4,4,5};
        System.out.println(findDuplicate(array));
        System.out.println(findDuplicateUsingSet(array));
        System.out.println(findDuplicateUsingSorting(array));
    }
    /*
     Brute Force approach
     Time Complexity O(n2)
     */
    public static int findDuplicate(int[] array) {
        int length = array.length;
       for (int i = 0; i < length; i++) {
           for(int j = i + 1; j < length; j++) {
               if(array[i] == array[j]) {
                   return array[i];
               }
           }
       }
       return -1;
    }
    /*
        Time Complexity O(n)
        Space Complexity O(n)
     */
    public static int findDuplicateUsingSet(int[] array) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(numbers.add(array[i]) == false){
                return array[i];
            }
        }
        return -1;
    }

    /*
        Time complexity: O(n log n)
     */
    public static int findDuplicateUsingSorting(int[] array) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if(array[i] == array[i+1]) {
                return array[i];
            }
        }

        return -1;
    }

}
