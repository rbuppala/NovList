package Trees;

/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.

    Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

 */
public class MinimumDepthOfBinaryTree {

    public static void main(String args[]) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);

        rootNode.left = leftNode;

        System.out.println(minDepth((rootNode)));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        //is root leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        return  1 + Math.min(leftDepth,rightDepth);

    }
}


