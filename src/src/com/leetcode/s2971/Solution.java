package src.com.leetcode.s2971;

import java.util.Arrays;

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (prefixSum[i - 1] > nums[i]) {
                return prefixSum[i];
            }
        }
        return -1;
    }
}