package src.com.leetcode.s129;

import src.com.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left == null && current.right == null) {
                sum += current.val;
            }
            int val = current.val * 10;
            if (current.left != null) {
                current.left.val += val;
                queue.offer(current.left);
            }
            if (current.right != null) {
                current.right.val += val;
                queue.offer(current.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        System.out.println(solution.sumNumbers(t1));

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(9);
        t2.right = new TreeNode(0);
        t2.left.left = new TreeNode(5);
        t2.left.right = new TreeNode(1);
        System.out.println(solution.sumNumbers(t2));
    }
}