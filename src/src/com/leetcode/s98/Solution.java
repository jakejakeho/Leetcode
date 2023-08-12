package src.com.leetcode.s98;

import src.com.utils.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null) {
            return true;
        }

        if ((minValue != null && root.val <= minValue) || (maxValue != null && root.val >= maxValue)) {
            return false;
        }
        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }
}
