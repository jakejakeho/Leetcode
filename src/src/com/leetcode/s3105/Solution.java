package src.com.leetcode.s3105;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int longest = 1;
        int increasing = 1;
        int decreasing = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff > 0) {
                increasing++;
                longest = Math.max(longest, increasing);
                decreasing = 1;
            } else if (diff < 0) {
                increasing = 1;
                decreasing++;
                longest = Math.max(longest, decreasing);
            } else {
                increasing = 1;
                decreasing = 1;
            }
        }
        return longest;
    }
}