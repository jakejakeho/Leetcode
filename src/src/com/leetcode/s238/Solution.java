package src.com.leetcode.s238;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
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
