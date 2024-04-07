package src.com.leetcode.s145;

import src.com.utils.TreeNode;

import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pointer = root;
        while (true) {
            while (pointer != null) {
                stack.push(pointer);
                stack.push(pointer);
                pointer = pointer.left;
            }

            if (stack.isEmpty()) {
                return list;
            }
            pointer = stack.pop();

            if (!stack.isEmpty() && pointer == stack.peek()) {
                pointer = pointer.right;
            } else {
                list.add(pointer.val);
                pointer = null;
            }
        }
    }
}