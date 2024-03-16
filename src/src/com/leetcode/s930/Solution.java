package src.com.leetcode.s930;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int num = 0;
        for (int length = Math.max(1, goal); length <= nums.length; length++) {
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += nums[i];
            }
            if (sum == goal) {
                num++;
            }
            for (int i = 0; i < nums.length - length; i++) {
                // shift right
                sum -= nums[i];
                sum += nums[i + length];
                if (sum == goal) {
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}