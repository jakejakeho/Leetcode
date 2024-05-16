package src.com.leetcode.s2331;

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
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        } else if (root.val == 2) {
            // OR
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else if (root.val == 3) {
            // AND
            return evaluateTree(root.left) && evaluateTree(root.right);
        } else {
            return root.val == 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode r1 = new TreeNode(2);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(3);
        r1.right.left = new TreeNode(0);
        r1.right.right = new TreeNode(1);
        System.out.println(solution.evaluateTree(r1));
        TreeNode r2 = new TreeNode(0);
        System.out.println(solution.evaluateTree(r2));
    }
}