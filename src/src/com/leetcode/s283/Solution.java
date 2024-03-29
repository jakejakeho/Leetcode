 package src.com.leetcode.s283;

class Solution {
    public void moveZeroes(int[] nums) {
        int numOfZero = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                numOfZero++;
            } else {
                nums[left++] = nums[right];
            }
            right++;
        }
        for (int i = 0; i < numOfZero; i++) {
            nums[left++] = 0;
        }
    }
}