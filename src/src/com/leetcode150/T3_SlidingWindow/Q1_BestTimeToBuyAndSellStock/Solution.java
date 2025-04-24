package src.com.leetcode150.T3_SlidingWindow.Q1_BestTimeToBuyAndSellStock;
class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        for (int right = 0; right < prices.length; right++) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }
}