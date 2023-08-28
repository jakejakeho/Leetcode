package src.com.leetcode.s213;
class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], Math.max(helper(nums, 0), helper(nums, nums.length - 1)));
    }

    public int helper(int[] nums, int skipId) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != skipId) {
                int temp = Math.max(rob1 + nums[i], rob2);
                rob1 = rob2;
                rob2 = temp;
            }
        }
        return rob2;
    }
}
