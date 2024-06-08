package src.com.leetcode.s1685;

import java.util.Arrays;

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = (i * nums[i]) - prefixSum[i] + (prefixSum[nums.length] - prefixSum[i + 1] - (nums.length - i - 1) * nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getSumAbsoluteDifferences(new int[]{2, 3, 5})));
    }
}