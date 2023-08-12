package src.com.leetcode.s95;

import src.com.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<TreeNode> generateTreesHelp(int l, int r) {
        if (l > r) {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(null);
            return ans;
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            // assume i as the root node
            List<TreeNode> left = generateTreesHelp(l, i - 1);
            List<TreeNode> right = generateTreesHelp(i + 1, r);

            for (TreeNode ln : left) {
                for (TreeNode rn : right) {
                    TreeNode root = new TreeNode(i, ln, rn);
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelp(1, n);
    }
}