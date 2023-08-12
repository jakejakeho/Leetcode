package src.com.leetcode.s1448;

import src.com.utils.TreeNode;

public class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }
        int numOfGoodNodes = root.val >= maxValue ? 1 : 0;
        int newMaxValue = Math.max(maxValue, root.val);
        int leftGoodNodes = dfs(root.left, newMaxValue);
        int rightGoodNodes = dfs(root.right, newMaxValue);
        numOfGoodNodes += leftGoodNodes;
        numOfGoodNodes += rightGoodNodes;
        return numOfGoodNodes;
    }
}
