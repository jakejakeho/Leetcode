package src.com.leetcode.s1614;

class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (s.charAt(i) == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(solution.maxDepth("()(())((()()))"));
    }
}