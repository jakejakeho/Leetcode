package src.com.leetcode.s72;
import java.util.Arrays;

class Solution {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recursion(word1, word2, dp, 0, 0);
    }

    private int recursion(String word1, String word2, int[][] dp, int i, int j) {
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            return word1.length() - i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minDistance = 1000000;
        if (word1.charAt(i) == word2.charAt(j)) {
            minDistance = recursion(word1, word2, dp, i + 1, j + 1);
            dp[i][j] = minDistance;
            return minDistance;
        }

        //insert a character
        minDistance = Math.min(minDistance, 1 + recursion(word1, word2, dp, i, j + 1));

        // delete a character
        minDistance = Math.min(minDistance, 1 + recursion(word1, word2, dp, i + 1, j));

        // replace a character
        minDistance = Math.min(minDistance, 1 + recursion(word1, word2, dp, i + 1, j + 1));

        dp[i][j] = minDistance;
        return minDistance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("intention", "execution"));
    }
}