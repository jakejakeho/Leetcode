package src.com.leetcode.s1470;

import java.util.Arrays;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int xIndex = 0;
        int yIndex = n;
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index++] = nums[xIndex++];
            result[index++] = nums[yIndex++];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }
}