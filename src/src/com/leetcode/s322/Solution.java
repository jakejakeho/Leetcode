package src.com.leetcode.s322;

import java.util.Arrays;

public
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (currentAmount - coin >= 0 && dp[currentAmount - coin] != Integer.MAX_VALUE) {
                    dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[currentAmount - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
