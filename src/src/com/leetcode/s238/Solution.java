package src.com.leetcode.s238;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int pre = 1;
        for (int i = 1; i < nums.length; i++) {
            pre *= nums[i - 1];
            result[i] = pre;
        }
        int suf = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suf *= nums[i + 1];
            result[i] *= suf;
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
