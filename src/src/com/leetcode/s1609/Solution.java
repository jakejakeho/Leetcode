package src.com.leetcode.s1609;

import src.com.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        boolean isOdd = false;
        boolean isIncreasing = false;
        int lastLevel = -1;
        Integer lastVal = null;
        Map<TreeNode, Integer> nodeLevel = new HashMap<>();
        nodeLevel.put(root, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int level = nodeLevel.get(currentNode);
            if (level != lastLevel) {
                isOdd = level % 2 == 0;
                isIncreasing = isOdd;
                lastLevel = level;
                lastVal = null;
            }
            boolean valIsOdd = !(currentNode.val % 2 == 0);
            if (isOdd && !valIsOdd) {
                System.out.println("case 1");
                return false;
            }
            if (!isOdd && valIsOdd) {
                System.out.println("case 2");
                return false;
            }
            if (isIncreasing && lastVal != null && currentNode.val <= lastVal) {
                System.out.println("case 3");
                return false;
            }
            if (!isIncreasing && lastVal != null && currentNode.val >= lastVal) {
                System.out.println("case 4");
                return false;
            }
            lastVal = currentNode.val;
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                nodeLevel.put(currentNode.left, level + 1);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                nodeLevel.put(currentNode.right, level + 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(2);
        System.out.println(solution.isEvenOddTree(root));
    }
}