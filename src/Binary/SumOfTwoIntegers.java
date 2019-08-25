package Binary;

/*
    371. Sum of Two Integers

    Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

    Example 1:

    Input: a = 1, b = 2
    Output: 3
    Example 2:

    Input: a = -2, b = 3
    Output: 1
 */
public class SumOfTwoIntegers {

    public static void main(String args[]) {
        int a = 3;
        int b = 2;
        System.out.println(add(a,b));
        System.out.println(addRecursive(a,b));
    }

    public static int add(int a, int b){
        int c ;

        while (b != 0) {
             c = a & b;
             a = a ^ b;
             b = c << 1;
        }
        return a;
    }


    public static int addRecursive(int a, int b) {
        return b == 0 ? a : addRecursive(a^b, (a&b) << 1);
    }
}
