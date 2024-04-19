package src.com.leetcode.s101;
import java.util.LinkedList;
import java.util.Queue;

import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            boolean leftNull = leftNode == null;
            boolean rightNull = rightNode == null;
            if (leftNull ^ rightNull || !leftNull && leftNode.val != rightNode.val) {
                return false;
            }
            if (!leftNull) {
                leftQueue.offer(leftNode.left);
                leftQueue.offer(leftNode.right);
            }

            if (!rightNull) {
                rightQueue.offer(rightNode.right);
                rightQueue.offer(rightNode.left);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(t1));
    }
}