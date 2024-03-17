package src.com.leetcode.s930;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    // count sum of subarrs where curSum <= x
    public int helper(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int result = 0;
        int leftPointer = 0;
        int current = 0;
        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            current += nums[rightPointer];
            while (current > goal) {
                current -= nums[leftPointer];
                leftPointer++;
            }
            result += (rightPointer - leftPointer) + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}