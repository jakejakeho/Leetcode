package src.com.leetcode.s209;
class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int minSubArraySize = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                minSubArraySize = Math.min(minSubArraySize, (right - left + 1));
                currentSum -= nums[left];
                left++;
            }
        }
        return minSubArraySize == Integer.MAX_VALUE ? 0 : minSubArraySize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
    }
}