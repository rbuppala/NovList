package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
    Invert Binary Tree

    Example:

    Input:

         4
       /   \
      2     7
     / \   / \
    1   3 6   9

    Output:

         4
       /   \
      7     2
     / \   / \
    9   6 3   1
 */
public class InvertBinaryTree {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        TreeNode secondLeft = new TreeNode(2);
        TreeNode secondRight = new TreeNode(7);
        TreeNode thirdLLeft = new TreeNode(1);
        TreeNode thirdLRight = new TreeNode(3);
        TreeNode thirdRLeft = new TreeNode(6);
        TreeNode thirdRRight = new TreeNode(9);

        secondLeft.left = thirdLLeft;
        secondLeft.right = thirdLRight;
        secondRight.left = thirdRLeft;
        secondRight.right = thirdRRight;

        root.left = secondLeft;
        root.right = secondRight;
        root.printTree();
        TreeNode newRoot = invertTree(root);
        newRoot.printTree();
    }
    /*
        Time Complexity O(n)
        Each node in the tree is visited once
     */
    public static TreeNode invertTree(TreeNode root) {
        //Base Condition
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;

        return root;
    }

    /*
        The idea is that we need to swap the left and right child of all nodes in the tree.
         So we create a queue to store nodes whose left and right child have not been swapped yet.
         Initially, only the root is in the queue. As long as the queue is not empty,
         remove the next node from the queue, swap its children, and add the children to the queue.
         Null nodes are not added to the queue. Eventually,
         the queue will be empty and all the children swapped, and we return the original root.
     */
    public TreeNode invertTreeIterative(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.right;
            current.right = current.left;
            current.left = temp;

            if (current.left != null)  queue.add(current.left);
            if (current.right != null) queue.add(current.right);

        }
        return root;
    }
}
