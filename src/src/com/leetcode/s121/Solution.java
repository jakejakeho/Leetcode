package src.com.leetcode.s121;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        System.out.println("Input: " + Arrays.toString(prices));
        System.out.println("Output: " + solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            if (currentProfit + profit < 0) {
                currentProfit = 0;
            } else {
                currentProfit += profit;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}
