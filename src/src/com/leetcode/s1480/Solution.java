package src.com.leetcode.s1480;

import java.util.Arrays;

class Solution {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        int s = 0;;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution.runningSum(new int[]{3, 1, 2, 10, 1})));
    }
}