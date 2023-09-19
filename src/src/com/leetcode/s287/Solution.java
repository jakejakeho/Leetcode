package src.com.leetcode.s287;

import java.util.Arrays;

public class Solution {
    public int findDuplicate(int[] nums) {
        int bits = 0;
        for (int i = 0; i < nums.length; i++) {
            bits = bits ^ nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            bits = bits ^ i;
        }
        return bits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        /**
         * Input: nums = [1,3,4,2,2]
         * Output: 2
         */

        nums = new int[]{1, 3, 4, 2, 2};
        System.out.println("Output = " + solution.findDuplicate(nums));
    }
}
