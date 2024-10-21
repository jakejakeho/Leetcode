package src.com.leetcode.s938;
import src.com.utils.TreeNode;

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        sum += rangeSumBST(root.left, low, high);
        sum += rangeSumBST(root.right, low, high);
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(15);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(7);
        t1.right.right = new TreeNode(18);
        System.out.println(solution.rangeSumBST(t1, 7, 15));
    }
}