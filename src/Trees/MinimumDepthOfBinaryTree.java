package Trees;

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


