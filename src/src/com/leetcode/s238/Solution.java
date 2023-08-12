package src.com.leetcode.s238;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            if (i >= 1) {
                prefix *= nums[i - 1];
            }
            result[i] = prefix;
        }

        int suffix = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j <= nums.length - 2) {
                suffix *= nums[j + 1];
            }
            result[j] *= suffix;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Solution solution = new Solution();

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(solution.productExceptSelf(nums)));
    }
}
