package src.com.leetcode.s863;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.com.utils.TreeNode;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = null;
        //root = new TreeNode(3);
        //root.left = new TreeNode(5);
        //root.right = new TreeNode(1);
        //root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(8);
        //root.left.left = new TreeNode(6);
        //root.left.right = new TreeNode(2);
        //root.left.right.left = new TreeNode(7);
        //root.left.right.right = new TreeNode(4);
        //System.out.println(solution.distanceK(root, root.left, 2));

        root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        System.out.println(solution.distanceK(root, root.left.right, 1));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        TreeNode[] treeNodes = new TreeNode[501];

        // bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
                treeNodes[current.left.val] = current.left;
            }

            if (current.right != null) {
                queue.add(current.right);
                treeNodes[current.right.val] = current.right;
            }
        }
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[501];
        recursive(root, target, k, treeNodes, answer, visited);
        return answer;
    }

    private void recursive(TreeNode root, TreeNode target, int k, TreeNode[] treeNodes, List<Integer> answer,
                           boolean[] visited) {
        if (k == 0) {
            answer.add(target.val);
            return;
        }
        // go parent
        TreeNode parentNode = treeNodes[target.val];
        if (parentNode != null && !visited[parentNode.val]) {
            visited[parentNode.val] = true;
            recursive(root, parentNode, k - 1, treeNodes, answer, visited);
            visited[parentNode.val] = false;
        }

        // go left
        TreeNode leftNode = target.left;
        if (leftNode != null && !visited[leftNode.val]) {
            visited[leftNode.val] = true;
            recursive(root, leftNode, k - 1, treeNodes, answer, visited);
            visited[leftNode.val] = false;
        }

        // go right
        TreeNode rightNode = target.right;
        if (rightNode != null && !visited[rightNode.val]) {
            visited[rightNode.val] = true;
            recursive(root, rightNode, k - 1, treeNodes, answer, visited);
            visited[rightNode.val] = true;
        }
    }
}