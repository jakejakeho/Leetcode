package src.com.leetcode.s1685;

import java.util.Arrays;

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            prefixSum[i] = leftSum;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            if (i != 0) {
                sum += i * nums[i];
                sum -= prefixSum[i - 1];
            }
            if (i != nums.length - 1) {
                sum += postfixSum(i , prefixSum);
                sum -= (nums.length - 1 - i) * nums[i];
            }
            result[i] = sum;
        }
        return result;
    }

    public int postfixSum(int i, int[] prefixSum) {
        return prefixSum[prefixSum.length - 1] - prefixSum[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getSumAbsoluteDifferences(new int[]{2, 3, 5})));
    }
}