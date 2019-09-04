package Trees.BST;

import Trees.TreeNode;

import java.util.Stack;

/*
    Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

    The binary search tree is guaranteed to have unique values.



    Example 1:

    Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
    Output: 32
    Example 2:

    Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
    Output: 23



 */
public class RangeSumOfBST {

    static int ans = 0;

    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        TreeNode leftToRoot = new TreeNode(5);
        TreeNode rightToRoot = new TreeNode(15);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(7);

        TreeNode rright1 = new TreeNode(18);

        root.left = leftToRoot;
        root.right = rightToRoot;

        leftToRoot.left = left1;
        leftToRoot.right = right1;

        rightToRoot.right = rright1;

        System.out.println(rangeSum(root, 7, 15));
        System.out.println(rangeSumBST(root, 7, 15));
    }
    /*
        Recursion
     */
    public static int rangeSum(TreeNode root, int left, int right) {
       dfs(root,left, right);
       return ans;
    }

    public static void dfs(TreeNode node, int left, int right) {
        if (node != null) {
            if (node.val >= left && node.val <= right) {
                ans += node.val;
            }

            if (left < node.val) {
                dfs(node.left, left, right);
            }

            if (node.val < right) {
                dfs(node.right, left, right);
            }

        }
    }


    public static int rangeSumBST(TreeNode root, int left, int right) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.val >= left && node.val <= right) {
                    ans += node.val;
                }
                if (left < node.val) {
                    stack.push(node.left);
                }

                if (node.val < right) {
                    stack.push(node.right);
                }
            }

        }
        return ans;
    }


}

