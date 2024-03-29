package src.com.leetcode.s1984;

import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minimumDifference = Integer.MAX_VALUE;
        int left = 0;
        int right = k - 1;
        while (right < nums.length) {
            minimumDifference = Math.min(nums[right] - nums[left], minimumDifference);
            left++;
            right++;
        }
        return minimumDifference;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDifference(new int[]{90}, 1));
        System.out.println(solution.minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }
}