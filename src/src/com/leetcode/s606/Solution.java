package src.com.leetcode.s606;

import com.sun.source.tree.Tree;
import src.com.utils.TreeNode;

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
    public String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val);
        if (root.left != null || root.right != null)
            stringBuilder.append(preOrder(root.left));
        if (root.right != null)
            stringBuilder.append(preOrder(root.right));

        return stringBuilder.toString();
    }

    public StringBuilder preOrder(TreeNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');

        if (node != null) {
            stringBuilder.append(node.val);
            if (node.left != null || node.right != null)
                stringBuilder.append(preOrder(node.left));
        }
        if (node != null && node.right != null) {
            stringBuilder.append(preOrder(node.right));
        }
        stringBuilder.append(')');
        return stringBuilder;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        System.out.println(solution.tree2str(t1));

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        System.out.println(solution.tree2str(t2));

        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.left.left = new TreeNode(3);
        t3.left.right = new TreeNode(4);
        System.out.println(solution.tree2str(t3));
    }
}