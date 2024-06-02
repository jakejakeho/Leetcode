package src.com.leetcode.s896;

class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            // increasing
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
        } else {
            // decreasing
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}