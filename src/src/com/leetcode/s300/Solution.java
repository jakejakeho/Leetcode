package src.com.leetcode.s300;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, 1);
        int longest = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    cache[i] = Math.max(cache[i], 1 + cache[j]);
                    longest = Math.max(longest, cache[i]);
                }
            }
        }
        return longest;
    }
}
