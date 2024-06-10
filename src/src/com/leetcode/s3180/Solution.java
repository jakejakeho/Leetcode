package src.com.leetcode.s3180;

import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;

        int sum = 0;
        for (int rewardValue : rewardValues) {
            sum += rewardValue;
        }

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);

        return helper(rewardValues, dp, 0, n, 0);
    }

    private int helper(int[] rewardValues, int[] dp, int i, int n, int currentRewards) {
        if (i == n) {
            return currentRewards;
        }

        if (dp[currentRewards] != -1) {
            return dp[i];
        }
        int max = 0;

        // not include this index
        max = Math.max(max, helper(rewardValues, dp, i + 1, n, currentRewards));


        // include this index
        if (rewardValues[i] > currentRewards)
            max = Math.max(max, helper(rewardValues, dp, i + 1, n, currentRewards + rewardValues[i]));
        dp[currentRewards] = max;
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxTotalReward(new int[]{1, 1, 3, 3}));
        System.out.println(solution.maxTotalReward(new int[]{1, 6, 4, 3, 2}));
    }
}