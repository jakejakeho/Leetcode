package src.com.leetcode.s394;

import java.util.Stack;

class Solution {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.insert(0, stack.pop());
                }
                stack.pop();
                int num = 0;
                int digit = 0;
                while (!stack.isEmpty() && (stack.peek() >= '0' && stack.peek() <= '9')) {
                    num += (int) ((stack.pop() - '0') * Math.pow(10, digit++));
                }
                for (int i = 0; i < num; i++) {
                    for (char c1 : temp.toString().toCharArray()) {
                        stack.push(c1);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println("---");
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println("---");
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
    }
}