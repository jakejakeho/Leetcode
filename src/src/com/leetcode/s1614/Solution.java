package src.com.leetcode.s1614;

class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                current++;
                max = Math.max(current, max);
            } else if (s.charAt(i) == ')') {
                current--;
            }
        }
        return max;
    }
}