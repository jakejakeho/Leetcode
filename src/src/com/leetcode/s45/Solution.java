package src.com.leetcode.s45;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected = 2 result = " + solution.jump(new int[] {2, 3, 1, 1, 4}));
        System.out.println("Expected = 2 result = " + solution.jump(new int[] {2, 3, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                ++ans;
                break;
            }
            if (i == end) {
                ans++;
                end = farthest;
            }
        }
        return ans;
    }
}