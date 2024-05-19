package src.com.leetcode.s979;

import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {

    public int distributeCoins(TreeNode root) {
        int[] moves = new int[] {0};
        dfs(root, moves);
        return moves[0];
    }

    private int dfs(TreeNode current, int[] moves) {
        if (current == null) {
            return 0;
        }
        int leftCoins = dfs(current.left, moves);
        int rightCoins = dfs(current.right, moves);

        moves[0] += Math.abs(leftCoins) + Math.abs(rightCoins);

        return current.val - 1 + leftCoins + rightCoins;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(0);
        t1.right = new TreeNode(0);
        System.out.println(solution.distributeCoins(t1));

        TreeNode t2 = new TreeNode(0);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(0);
        System.out.println(solution.distributeCoins(t2));

        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(0);
        t3.right = new TreeNode(2);
        System.out.println(solution.distributeCoins(t3));

        TreeNode t4 = new TreeNode(4);
        t4.left = new TreeNode(0);
        t4.left.right = new TreeNode(0);
        t4.left.right.right = new TreeNode(0);
        System.out.println(solution.distributeCoins(t4));
    }
}