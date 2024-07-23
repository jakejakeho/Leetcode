package src.com.leetcode.s746;


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 3];
        for (int i = dp.length - 3; i >= 0; i--) {
            int currentCost = i - 1 >= 0 ? cost[i - 1] : 0;
            dp[i] = Math.min(currentCost + dp[i + 1], currentCost + dp[i + 2]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}