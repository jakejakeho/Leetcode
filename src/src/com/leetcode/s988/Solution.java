package src.com.leetcode.s988;

import src.com.utils.TreeNode;

import java.util.*;

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
    public String smallestFromLeaf(TreeNode root) {
        List<String> smallest = new ArrayList<>();
        smallestFromLeaf(root, smallest, new StringBuilder());
        return smallest.get(0);
    }

    private void smallestFromLeaf(TreeNode root, List<String> smallest, StringBuilder stringBuilder) {
        stringBuilder.append((char)('a' + root.val));
        if (root.left == null && root.right == null) {
            stringBuilder.reverse();
            String current = stringBuilder.toString();
            stringBuilder.reverse();

            if (smallest.isEmpty()) {
                smallest.add(current);
            } else if (current.compareTo(smallest.get(0)) < 0) {
                smallest.set(0, current);
            }
        }
        if (root.left != null)
            smallestFromLeaf(root.left, smallest, stringBuilder);
        if (root.right != null)
            smallestFromLeaf(root.right, smallest, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(0);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);
        t1.right.left = new TreeNode(3);
        t1.right.right = new TreeNode(4);
        System.out.println(solution.smallestFromLeaf(t1));

        TreeNode t2 = new TreeNode(25);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.left = new TreeNode(1);
        t2.left.right = new TreeNode(3);
        t2.right.left = new TreeNode(0);
        t2.right.right = new TreeNode(2);
        System.out.println(solution.smallestFromLeaf(t2));
    }
}