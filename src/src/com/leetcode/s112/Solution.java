package src.com.leetcode.s112;

import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int newSum = targetSum - root.val;
        if (newSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean left = hasPathSum(root.left, newSum);
        boolean right = hasPathSum(root.right, newSum);
        return left || right;
    }
}