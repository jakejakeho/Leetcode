package src.com.leetcode.s1423;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScore(new int[] {1, 2, 3, 4, 5, 6, 1}, 3));
    }

    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int currentScore = 0;
        for (int i = 0; i < k; i++) {
            currentScore += cardPoints[i];
        }
        maxScore = Math.max(maxScore, currentScore);
        for (int i = 0; i < k; i++) {
            currentScore -= cardPoints[k - i - 1];
            currentScore += cardPoints[cardPoints.length - 1 - i];
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
}