package src.com.leetcode.s1530;

import src.com.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public int countPairs(TreeNode root, int distance) {
        int pairs = 0;
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> currentPath = new ArrayList<>();
        currentPath.add(root);
        dfs(root, list, currentPath);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<TreeNode> path1 = list.get(i);
                List<TreeNode> path2 = list.get(j);
                int dis = distance(path1, path2);
                if (dis <= distance) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    private int distance(List<TreeNode> path1, List<TreeNode> path2) {
        int distance = 0;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                int dist1 = path1.size() - i - 1;
                int dist2 = path2.size() - i - 1;
                distance = dist1 + dist2;
            } else {
                break;
            }
        }
        return distance;
    }

    private void dfs(TreeNode root, List<List<TreeNode>> list, List<TreeNode> currentPath) {
        if (root.left == null && root.right == null) {
            list.add(currentPath);
            return;
        }
        if (root.left != null) {
            List<TreeNode> leftPath = new ArrayList<>(currentPath);
            leftPath.add(root.left);
            dfs(root.left, list, leftPath);
        }

        if (root.right != null) {
            List<TreeNode> rightPath = new ArrayList<>(currentPath);
            rightPath.add(root.right);
            dfs(root.right, list, rightPath);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.right = new TreeNode(4);
        System.out.println(solution.countPairs(t1, 3));

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left.left = new TreeNode(4);
        t2.left.right = new TreeNode(5);
        t2.right.left = new TreeNode(6);
        t2.right.right = new TreeNode(8);
        System.out.println(solution.countPairs(t2, 3));
    }
}