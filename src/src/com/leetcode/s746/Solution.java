package src.com.leetcode.s746;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] minCosts = new int[cost.length ];
        Arrays.fill(minCosts, -1);
        return dfs(cost, minCosts, -1);
    }

    private int dfs(int[] cost, int[] minCosts, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (i >= 0 && minCosts[i] != -1) {
            return minCosts[i];
        }
        int currentCost = 0;
        if (i != -1) {
            currentCost = cost[i];
        }
        currentCost += Math.min(dfs(cost, minCosts, i + 1), dfs(cost, minCosts, i + 2));
        if (i >= 0)
            minCosts[i] = currentCost;
        return currentCost;
    }
}