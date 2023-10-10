package src.com.leetcode.s53;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int newSum = currentSum + nums[i];
            if (nums[i] >= newSum) {
                currentSum = nums[i];
            } else {
                currentSum = newSum;
            }
            max = Math.max(max, currentSum);
        }
        return max;
    }
}