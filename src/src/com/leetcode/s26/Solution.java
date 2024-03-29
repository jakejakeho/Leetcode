package src.com.leetcode.s26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int lastNum = Integer.MIN_VALUE;
        while (right < nums.length) {
            if (nums[right] != lastNum) {
                nums[left++] = nums[right];
                lastNum = nums[right];
            }
            right++;
        }
        return left;
    }
}