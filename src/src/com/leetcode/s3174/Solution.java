package src.com.leetcode.s3174;

import java.util.Stack;

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (!stack.isEmpty()) {
                    if (!(stack.peek() >= '0' && stack.peek() <= '9'))
                        stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.clearDigits("abc"));
        System.out.println(solution.clearDigits("cb34"));
    }
}