package src.com.leetcode.s3107;

import java.util.Arrays;


class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[nums.length / 2] == k) {
            return 0;
        }
        long minOperations = Long.MAX_VALUE;
        long leftOperations = 0;
        for (int i = 0; i <= (nums.length / 2); i++) {
            if (nums[i] > k) {
                leftOperations += ((long)nums[i] - (long)k);
            }
        }
        if (leftOperations > 0)
            minOperations = leftOperations;
        long rightOperation = 0;
        for (int i = nums.length / 2; i < nums.length; i++) {
            if (nums[i] < k) {
                rightOperation += ((long)k - (long)nums[i]);
            }
        }
        if (rightOperation > 0)
            minOperations = Math.min(minOperations, rightOperation);
        return minOperations;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperationsToMakeMedianK(new int[]{2, 5, 5, 6, 8}, 4));
        System.out.println(solution.minOperationsToMakeMedianK(new int[]{2, 5, 5, 6, 8}, 7));
        System.out.println(solution.minOperationsToMakeMedianK(new int[]{1, 2, 3, 4, 5, 6}, 4));
        System.out.println(solution.minOperationsToMakeMedianK(new int[]{98, 52}, 82));
    }
}