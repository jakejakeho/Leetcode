package src.com.leetcode.s1422;

class Solution {
    public int maxScore(String s) {
        int leftScore = s.charAt(0) == '0' ? 1 : 0;
        int rightScore = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightScore++;
            }
        }

        int maxScore = leftScore + rightScore;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                rightScore--;
            } else {
                leftScore++;
            }
            maxScore = Math.max(leftScore + rightScore, maxScore);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScore("011101"));
        System.out.println(solution.maxScore("00"));
    }
}