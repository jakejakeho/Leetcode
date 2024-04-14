package src.com.leetcode.s402;

import java.util.LinkedList;

class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char current : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && current < stack.peekLast()) {
                k--;
                stack.removeLast();
            }
            stack.addLast(current);
        }

        while (k > 0) {
            k--;
            stack.removeLast();
        }

        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        for (char c : stack) {
            if (leadingZero && c == '0') continue;
            leadingZero = false;
            res.append(c);
        }
        if (res.isEmpty()) return "0";
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
        System.out.println(solution.removeKdigits("10200", 1));
        System.out.println(solution.removeKdigits("10", 2));
        System.out.println(solution.removeKdigits("1", 1));
        System.out.println(solution.removeKdigits("112", 1));
    }
}