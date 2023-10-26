package src.com.leetcode.s416;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target];
        dp[0] = true;

        for (int no : nums) {
            for (int i = target; i >= no; i--) {
                if (dp[i - no]) {
                    if (i == target) return true;
                    dp[i] = true;
                }
            }
        }
        return false;
    }
}