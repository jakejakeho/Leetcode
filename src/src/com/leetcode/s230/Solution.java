package src.com.leetcode.s230;

import src.com.utils.TreeNode;

import java.util.Objects;
import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || Objects.nonNull(curr)) {
            while (Objects.nonNull(curr)) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k -= 1;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }
}
