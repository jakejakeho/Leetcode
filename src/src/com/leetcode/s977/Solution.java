package src.com.leetcode.s977;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }
        int firstPositiveIndex = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (firstPositiveIndex == nums.length && nums[i] >= 0) {
                firstPositiveIndex = i;
            }
            nums[i] = nums[i] * nums[i];
        }
        int left = firstPositiveIndex - 1;
        int right = firstPositiveIndex;
        int[] sorted = new int[nums.length];
        int index = 0;
        while (left >= 0 || right < nums.length) {
            boolean leftNotDone = left >= 0;
            boolean rightNotDone = right < nums.length;
            if (!leftNotDone) {
                sorted[index++] = nums[right++];
            } else if (!rightNotDone) {
                sorted[index++] = nums[left--];
            } else {
                if (nums[left] <= nums[right]) {
                    sorted[index++] = nums[left--];
                } else {
                    sorted[index++] = nums[right++];
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}