package src.com.leetcode.s1910;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public String removeOccurrences(String s, String part) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
            int leftIndex = stack.size() - 1;
            int rightIndex = part.length() - 1;
            while (!stack.isEmpty() && leftIndex >= 0 && rightIndex >= 0 && stack.get(leftIndex)
                                                                                 .equals(part.charAt(rightIndex))) {
                leftIndex--;
                rightIndex--;
            }
            if (rightIndex < 0) {
                for (int j = 0; j < part.length(); j++) {
                    stack.remove(stack.size() - 1);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character character : stack) {
            result.append(character);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOccurrences("daabcbaabcbc", "abc")); //dab
    }
}