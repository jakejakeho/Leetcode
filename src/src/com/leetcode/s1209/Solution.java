package src.com.leetcode.s1209;
import java.util.Stack;

class Solution {

    private static class Grouped {

        char currentChar;

        int count = 0;

        @Override
        public String toString() {
            return "currentChar = " + currentChar + " count = " + count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Grouped> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                Grouped grouped = new Grouped();
                grouped.currentChar = s.charAt(i);
                grouped.count++;
                stack.push(grouped);
            } else {
                if (s.charAt(i) == stack.peek().currentChar) {
                    stack.peek().count++;
                } else {
                    Grouped grouped = new Grouped();
                    grouped.currentChar = s.charAt(i);
                    grouped.count++;
                    stack.push(grouped);
                }
            }
            if (stack.peek().count == k) {
                Grouped grouped = stack.pop();
                System.out.println("popped = " + grouped);
                System.out.println(stack);
                while (stack.size() >= 2) {
                    Grouped lastGroup = stack.pop();
                    if (stack.peek().currentChar != lastGroup.currentChar) {
                        break;
                    }
                    // merge
                    stack.peek().count += lastGroup.count;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Grouped grouped = stack.pop();
            for (int i = 0; i < grouped.count; i++) {
                stringBuilder.append(grouped.currentChar);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abcd", 2));
        System.out.println(solution.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(solution.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}