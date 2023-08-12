package src.com.leetcode.s122;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {1,2,3,4,5}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        Integer buyPrice = null;
        for (int i = 0; i < prices.length - 1; i++) {
            boolean isProfitNextDay = prices[i + 1] - prices[i] > 0;
            if (buyPrice == null) {
                if (isProfitNextDay) {buyPrice = prices[i];}
            } else {
                if (!isProfitNextDay) {
                    int sellPrice = prices[i];
                    int profit = sellPrice - buyPrice;
                    buyPrice = null;
                    maxProfit += profit;
                }
            }
        }
        if (buyPrice != null) {
            // sell at last day
            int sellPrice = prices[prices.length - 1];
            int profit = sellPrice - buyPrice;
            buyPrice = null;
            maxProfit += profit;
        }
        return maxProfit;
    }
}