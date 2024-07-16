package src.com.leetcode.s2096;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {

    private record Path(TreeNode currentNode, StringBuilder path) {}

    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (parent.val == startValue) {
                startNode = parent;
            }
            if (parent.left != null) {
                queue.offer(parent.left);
                parentMap.put(parent.left, parent);
            }
            if (parent.right != null) {
                queue.offer(parent.right);
                parentMap.put(parent.right, parent);
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        Queue<Path> pathQueue = new LinkedList<>();
        pathQueue.offer(new Path(startNode, new StringBuilder()));
        while (!pathQueue.isEmpty()) {
            int size = pathQueue.size();
            for (int i = 0; i < size; i++) {
                Path currentPath = pathQueue.poll();
                TreeNode currentNode = currentPath.currentNode;
                visited.add(currentNode);
                // match
                if (currentNode.val == destValue) {
                    return currentPath.path.toString();
                }
                // go up
                if (parentMap.containsKey(currentNode)) {
                    TreeNode parentNode = parentMap.get(currentNode);
                    if (!visited.contains(parentNode)) {
                        pathQueue.offer(
                            new Path(parentMap.get(currentNode), new StringBuilder(currentPath.path).append("U")));
                    }
                }

                // go left
                if (currentNode.left != null) {
                    TreeNode leftNode = currentNode.left;
                    if (!visited.contains(leftNode)) {
                        pathQueue.offer(new Path(currentNode.left, new StringBuilder(currentPath.path).append("L")));
                    }
                }

                // go right
                if (currentNode.right != null) {
                    TreeNode rightNode = currentNode.right;
                    if (!visited.contains(rightNode)) {
                        pathQueue.offer(new Path(currentNode.right, new StringBuilder(currentPath.path).append("R")));
                    }
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(1);
        t1.left.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(4);
        System.out.println(solution.getDirections(t1, 3, 6));

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        System.out.println(solution.getDirections(t2, 2, 1));
    }
}