package src.com.leetcode.s199;

import src.com.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int lastVal = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode current = queue.poll();
                lastVal = current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(lastVal);
        }
        return result;
    }
}
