package src.com.leetcode.s110;

public class Solution {

    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diff = rightHeight - leftHeight;
        isBalanced &= (diff >= -1 && diff <= 1);
        return isBalanced;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diff = rightHeight - leftHeight;
        isBalanced &= (diff >= -1 && diff <= 1);
        return 1 + (Math.max(leftHeight, rightHeight));
    }
}
