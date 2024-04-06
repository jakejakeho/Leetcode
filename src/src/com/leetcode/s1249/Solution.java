package src.com.leetcode.s1249;

import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> charToDelete = new Stack<>();
        int currentIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(currentIndex);
                currentIndex++;
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    currentIndex++;
                } else {
                    charToDelete.push(i);
                }
            } else {
                currentIndex++;
            }
        }
        while (!charToDelete.isEmpty()) {
            sb.deleteCharAt(charToDelete.pop());
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(solution.minRemoveToMakeValid("))(("));
    }
}