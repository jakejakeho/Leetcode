package src.com.leetcode.s1190;

import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new StringBuilder());
            } else if (s.charAt(i) == ')') {
                StringBuilder reversed = stack.pop().reverse();
                stack.peek().append(reversed);
            } else {
                stack.peek().append(s.charAt(i));
            }
        }
        return stack.peek().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses("(abcd)"));
        System.out.println(solution.reverseParentheses("(u(love)i)"));
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}