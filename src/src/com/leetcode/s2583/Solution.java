package src.com.leetcode.s2583;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> levelSumMap = new HashMap<>();
        recursion(root, levelSumMap, 0);
        List<Long> sums = new ArrayList<>(levelSumMap.values());
        sums.sort(Comparator.reverseOrder());
        if (k - 1 >= sums.size()) {return -1;}
        return sums.get(k - 1);
    }

    private void recursion(TreeNode root, Map<Integer, Long> levelSumMap, int level) {
        if (root == null) {
            return;
        }
        levelSumMap.put(level, levelSumMap.getOrDefault(level, 0L) + root.val);
        recursion(root.left, levelSumMap, level + 1);
        recursion(root.right, levelSumMap, level + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);
        //treeNode.left.left.left = new TreeNode(4);
        //treeNode.left.left.right = new TreeNode(6);
        System.out.println(solution.kthLargestLevelSum(treeNode, 4));
    }
}