package src.com.leetcode.s62;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(23, 12));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the rightmost column and bottom row to 1 since there is only one way to reach
        // any cell in the rightmost column or the bottom row - by moving right or down.
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        // Fill in the DP array bottom-up.
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}