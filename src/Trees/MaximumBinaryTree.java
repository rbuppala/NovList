package Trees;

/*
    Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    Construct the maximum tree by the given array and output the root node of this tree.
 */
public class MaximumBinaryTree {

    public static void main(String args[]) {
        int[] array = {3,2,1,6,0,5};
        constructMaximumBinaryTree(array).printTree();
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
       return  construct(nums, 0, nums.length);
    }

    public static TreeNode construct(int[] nums, int l, int r) {
        if (l == r) return null;

        int maxIndex = max(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, l, maxIndex);
        root.right = construct(nums, maxIndex +1, r);

        return root;
    }

    private static int max(int[] array, int left, int right) {
        int maxIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
