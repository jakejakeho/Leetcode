package src.com.leetcode.s309;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recursive(prices, dp, 0, true);
    }

    private int recursive(int[] prices, int[][] dp, int i, boolean buying) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][buying ? 1 : 0] == -1) {
            int coolDown = recursive(prices, dp, i + 1, buying);
            int buyOSell = Integer.MIN_VALUE;
            if (buying) {
                buyOSell = recursive(prices, dp, i + 1, !buying) - prices[i];
            } else {
                buyOSell = recursive(prices, dp, i + 2, !buying) + prices[i];
            }
            dp[i][buying ? 1 : 0] = Math.max(coolDown, buyOSell);
        }
        return dp[i][buying ? 1 : 0];
    }
}
