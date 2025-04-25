package src.com.leetcode150.T4_Stack.Q3_EvaluateReversePolishNotation;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (List.of("+", "-", "*", "/")
                    .contains(tokens[i])) {
                String operator = tokens[i];
                int v2 = stack.pop();
                int v1 = stack.pop();
                int result = 0;
                if (Objects.equals(operator, "+")) {
                    result = v1 + v2;
                } else if (Objects.equals(operator, "-")) {
                    result = v1 - v2;
                } else if (Objects.equals(operator, "*")) {
                    result = v1 * v2;
                } else if (Objects.equals(operator, "/")) {
                    result = v1 / v2;
                }
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(tokens[i]));

            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}