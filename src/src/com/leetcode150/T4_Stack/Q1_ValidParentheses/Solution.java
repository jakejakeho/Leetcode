package src.com.leetcode150.T4_Stack.Q1_ValidParentheses;
import java.util.Stack;

class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
                return false;
            }
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                if (stack.peek()
                         .equals('(')) {stack.pop();} else {return false;}
            }

            if (!stack.isEmpty() && s.charAt(i) == ']') {
                if (stack.peek()
                         .equals('[')) {stack.pop();} else {return false;}
            }

            if (!stack.isEmpty() && s.charAt(i) == '}') {
                if (stack.peek()
                         .equals('{')) {stack.pop();} else {return false;}
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([])"));
    }
}