package src.com.leetcode.s2966;

import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int size = nums.length / 3;
        int[][] arrays = new int[size][3];
        Arrays.sort(nums);
        for (int i = 0; i < arrays.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arrays[0].length; j++) {
                arrays[i][j] = nums[i * 3 + j];
                max = Math.max(arrays[i][j], max);
                min = Math.min(arrays[i][j], min);
            }
            if (Math.abs(max - min) > k) {
                return new int[][]{};
            }
        }
        return arrays;
    }
}