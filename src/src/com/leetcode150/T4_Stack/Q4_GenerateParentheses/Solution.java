package src.com.leetcode150.T4_Stack.Q4_GenerateParentheses;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursion(0, n, result, "");
        return result;
    }

    private void recursion(int i, int n, List<String> result, String s) {
        if (i == 2 * n) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        // '('
        recursion(i + 1, n, result, s + '(');
        // ')'
        recursion(i + 1, n, result, s + ')');
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty())
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(1));
    }
}