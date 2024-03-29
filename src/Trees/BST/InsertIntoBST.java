package Trees.BST;

import Trees.TreeNode;

/*
    Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
     insert the value into the BST. Return the root node of the BST after the insertion.

      It is guaranteed that the new value does not exist in the original BST.

    Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

    For example,

    Given the tree:
            4
           / \
          2   7
         / \
        1   3
    And the value to insert: 5
    You can return this binary search tree:

             4
           /   \
          2     7
         / \   /
        1   3 5
    This tree is also valid:

             5
           /   \
          2     7
         / \
        1   3
             \
              4
 */
public class InsertIntoBST {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);

        TreeNode rleft = new TreeNode(2);
        TreeNode rright = new TreeNode(7);

        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(3);

        root.left = rleft;
        root.right = rright;

        rleft.left = left1;
        rleft.right = right1;

        //TreeNode newNode = insertIntoBST(root, 5);
        //newNode.printTree();

        TreeNode newNode = insertIntoBSTIterative(root, 5);
        newNode.printTree();
    }

    /**
     *   Recursive method
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     *   Iterative Method
     */
    public static TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;

        while (true) {
            if (current.val <= val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

}
