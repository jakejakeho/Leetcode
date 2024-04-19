package src.com.leetcode.s783;
import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {

    public int minDiffInBST(TreeNode root) {
        int[] passByReference = new int[2];
        passByReference[0] = Integer.MAX_VALUE;
        passByReference[1] = -1;
        inOrder(root, passByReference);
        return passByReference[0];
    }

    private void inOrder(TreeNode node, int[] passByReference) {
        if (node == null) {
            return;
        }
        inOrder(node.left, passByReference);
        if (passByReference[1] != -1) {
            int distance = Math.abs(node.val - passByReference[1]);
            passByReference[0] = Math.min(distance, passByReference[0]);
        }
        passByReference[1] = node.val;
        inOrder(node.right, passByReference);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(6);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);
        System.out.println(solution.minDiffInBST(t1));
    }
}