package src.com.leetcode.s150;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            stack.push(tokens[i]);
            if (Objects.equals(stack.peek(), "+")) {
                stack.pop();
                Long v2 = Long.valueOf(stack.pop());
                Long v1 = Long.valueOf(stack.pop());
                Long result = v1 + v2;
                stack.push(String.valueOf(result));
            } else if (Objects.equals(stack.peek(), "-")) {
                stack.pop();
                Long v2 = Long.valueOf(stack.pop());
                Long v1 = Long.valueOf(stack.pop());
                Long result = v1 - v2;
                stack.push(String.valueOf(result));
            } else if (Objects.equals(stack.peek(), "*")) {
                stack.pop();
                Long v2 = Long.valueOf(stack.pop());
                Long v1 = Long.valueOf(stack.pop());
                Long result = v1 * v2;
                stack.push(String.valueOf(result));
            } else if (Objects.equals(stack.peek(), "/")) {
                stack.pop();
                Long v2 = Long.valueOf(stack.pop());
                Long v1 = Long.valueOf(stack.pop());
                Long result = v1 / v2;
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println("Input: tokens = " + Arrays.toString(tokens));
        System.out.println("Output: " + solution.evalRPN(tokens));

        tokens = new String[]{"4","13","5","/","+"};
        System.out.println("Input: tokens = " + Arrays.toString(tokens));
        System.out.println("Output: " + solution.evalRPN(tokens));

        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Input: tokens = " + Arrays.toString(tokens));
        System.out.println("Output: " + solution.evalRPN(tokens));
    }
}
