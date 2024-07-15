package src.com.leetcode.s2198;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<TreeNode> children = new HashSet<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;
            map.computeIfAbsent(parent, TreeNode::new);
            map.computeIfAbsent(child, TreeNode::new);
            if (isLeft) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }
            children.add(map.get(child));
        }
        for (TreeNode node : map.values()) {
            if (!children.contains(node)) {
                // root node fonud
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
            solution.createBinaryTree(new int[][] {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}));
    }
}