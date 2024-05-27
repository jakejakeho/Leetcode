package src.com.leetcode.s1608;

import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int x = nums.length; x >= 0; x--) {
            if (x == 0) {
                if (nums[nums.length - 1] < 0) {
                    return x;
                }
            } else if (nums[nums.length - x] >= x && (nums.length - x - 1 < 0 || nums[nums.length - x - 1] < x)) {
                return x;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.specialArray(new int[]{3, 5}));
        System.out.println(solution.specialArray(new int[]{0, 0}));
        System.out.println(solution.specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(solution.specialArray(new int[]{3, 6, 7, 7, 0}));
    }
}