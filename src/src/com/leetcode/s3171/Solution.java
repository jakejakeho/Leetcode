package src.com.leetcode.s3171;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Set[] dp = new HashSet[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashSet<>();
        }
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (dp[j].contains(curr)) {
                    break;
                }
                curr &= nums[j];
                min = Math.min(min, Math.abs(k - curr));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDifference(new int[]{1, 2, 4, 5}, 3));
        System.out.println(solution.minimumDifference(new int[]{1, 2, 1, 2}, 2));
        System.out.println(solution.minimumDifference(new int[]{1}, 10));
    }
}