package src.com.leetcode.s513;

import src.com.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Map<TreeNode, Integer> heightMap = new HashMap<>();
        heightMap.put(root, 0);
        int maxHeight = -1;
        TreeNode bottomLeftNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int currentHeight = heightMap.get(currentNode);
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
                bottomLeftNode = currentNode;
            }
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                heightMap.put(currentNode.left, currentHeight + 1);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                heightMap.put(currentNode.right, currentHeight + 1);
            }
        }
        return bottomLeftNode.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution.findBottomLeftValue(root));
    }
}