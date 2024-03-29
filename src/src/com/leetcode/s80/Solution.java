package src.com.leetcode.s80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int lastNum = Integer.MIN_VALUE;
        int duplicateCount = 0;

        while (right < nums.length) {
            if (nums[right] != lastNum) {
                lastNum = nums[right];
                duplicateCount = 0;
            }
            if (duplicateCount <= 1) {
                nums[left] = nums[right];
                left++;
                duplicateCount++;
            }
            right++;
        }
        return left;
    }
}