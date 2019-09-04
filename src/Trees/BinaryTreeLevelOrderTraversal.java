package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    102. Binary Tree Level Order Traversal

    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
 */
public class BinaryTreeLevelOrderTraversal {

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

        System.out.println(levelOrder(root));
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(root == null) return wrapList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<Integer>();

            while(size-- > 0) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                levelList.add(queue.poll().val);
             }
            wrapList.add(levelList);
        }
        return wrapList;
    }
}
