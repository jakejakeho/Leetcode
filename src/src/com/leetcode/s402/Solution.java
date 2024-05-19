package src.com.leetcode.s402;
import java.util.LinkedList;

class Solution {

    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        int popped = 0;
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && popped < k && stack.peekLast() > digit) {
                stack.removeLast();
                popped++;
            }
            stack.addLast(digit);
        }

        while (!stack.isEmpty() && popped < k) {
            stack.removeLast();
            popped++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean isLeadingZero = true;
        for (char digit: stack) {
            if (isLeadingZero && digit == '0') continue;
            isLeadingZero = false;
            stringBuilder.append(digit);
        }
        if (stringBuilder.isEmpty()) {
            return "0";
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
        System.out.println(solution.removeKdigits("10200", 1));
    }
}