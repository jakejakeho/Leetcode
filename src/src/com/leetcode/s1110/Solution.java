package src.com.leetcode.s1110;

import com.sun.source.tree.Tree;
import src.com.utils.TreeNode;

import java.util.*;

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int toDelete : to_delete) {
            set.add(toDelete);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            if (!set.contains(root.val)) {
                list.add(root);
            }
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (set.contains(node.val)) {
                    TreeNode parentNode = parentMap.get(node);
                    if (parentNode != null) {
                        if (parentNode.left == node) {
                            parentNode.left = null;
                        } else if (parentNode.right == node) {
                            parentNode.right = null;
                        }
                    }

                    if (node.left != null && !set.contains(node.left.val)) {
                        list.add(node.left);
                    }
                    if (node.right != null && !set.contains(node.right.val)) {
                        list.add(node.right);
                    }
                }
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    parentMap.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right = new TreeNode(3);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        System.out.println(solution.delNodes(t1, new int[]{3, 5}));

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(4);
        t2.left.right = new TreeNode(3);
        System.out.println(solution.delNodes(t2, new int[]{3}));
    }
}