package Trees;

/*
    Maximum Depth of Binary Tree

    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Given binary tree [3,9,20,null,null,15,7],
     3
   / \
  9  20
    /  \
   15   7

   return its depth = 3.
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        TreeNode leftToRoot = new TreeNode(9);
        TreeNode rightToRoot = new TreeNode(20);
        TreeNode left15 = new TreeNode(15);
        TreeNode right15 = new TreeNode(7);

        root.left = leftToRoot;
        root.right = rightToRoot;
        rightToRoot.left = left15;
        rightToRoot.right = right15;

        System.out.println(maxDepth(root));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth((root.right)));
    }

}
