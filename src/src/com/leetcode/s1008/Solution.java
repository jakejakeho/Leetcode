package src.com.leetcode.s1008;

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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] < root.val) {
                root.left = dfs(preorder, i, Integer.MIN_VALUE, root.val);
                break;
            }
        }
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > root.val) {
                root.right = dfs(preorder, i, root.val, Integer.MAX_VALUE);
                break;
            }
        }
        return root;
    }

    private TreeNode dfs(int[] preorder, int index, int min, int max) {
        TreeNode root = new TreeNode(preorder[index]);
        if (index + 1 < preorder.length && preorder[index + 1] < root.val && preorder[index + 1] > min && preorder[index + 1] < max) {
            root.left = dfs(preorder, index + 1, min, preorder[index]);
        }
        for (int rightIndex = index + 1; rightIndex < preorder.length; rightIndex++) {
            if (preorder[rightIndex] > preorder[index] && preorder[rightIndex] > min && preorder[rightIndex] < max) {
                root.right = dfs(preorder, rightIndex, preorder[index], max);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode res = solution.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        TreeNode res1 = solution.bstFromPreorder(new int[]{4, 10, 7, 9, 11});
        System.out.println(res);
    }
}