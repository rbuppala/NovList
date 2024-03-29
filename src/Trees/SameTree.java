package Trees;
/*
    Given two binary trees, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

    Example 1:

    Input:     1         1
              / \       / \
             2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true
    Example 2:

    Input:     1         1
              /           \
             2             2

            [1,2],     [1,null,2]

    Output: false
 */
public class SameTree {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        root.left = second;

        TreeNode root1 = new TreeNode(1);
        TreeNode second1 = new TreeNode(2);
        root1.right = second1;

        System.out.println(isSameTree(root, root1));

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null && q!= null) return false;
        if (q == null && p!= null) return false;

        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

}
