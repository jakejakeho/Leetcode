package src.com.leetcode.s623;

import src.com.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;
        while (currentDepth < depth - 1) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            currentDepth++;
        }
        for (TreeNode node : queue) {
            TreeNode originalLeft = node.left;
            TreeNode originalRight = node.right;

            node.left = new TreeNode(val);
            if (originalLeft != null) {
                node.left.left = originalLeft;
            }
            node.right = new TreeNode(val);
            if (originalRight != null) {
                node.right.right = originalRight;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(6);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(1);
        t1.right.left = new TreeNode(5);
//        System.out.println(solution.addOneRow(t1, 1, 2));
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left.left = new TreeNode(4);
        System.out.println(solution.addOneRow(t2, 5, 4));
    }
}