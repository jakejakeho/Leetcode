package src.com.leetcode.s912;

import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int[] aArray = sortArray(subArray(nums, 0, nums.length / 2));
        int[] bArray = sortArray(subArray(nums, nums.length / 2, nums.length));

        return merge(aArray, bArray);
    }

    private int[] merge(int[] aArray, int[] bArray) {
        int[] mergeArray = new int[aArray.length + bArray.length];

        int mergeIndex = 0;
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < aArray.length && bIndex < bArray.length) {
            if (aArray[aIndex] <= bArray[bIndex]) {
                mergeArray[mergeIndex++] = aArray[aIndex++];
            } else {
                mergeArray[mergeIndex++] = bArray[bIndex++];
            }
        }

        if (aIndex < aArray.length) {
            System.arraycopy(aArray, aIndex, mergeArray, mergeIndex, aArray.length - aIndex);
        }

        if (bIndex < bArray.length) {
            System.arraycopy(bArray, bIndex, mergeArray, mergeIndex, bArray.length - bIndex);
        }

        return mergeArray;
    }

    private int[] subArray(int[] nums, int startIndex, int endIndex) {
        return Arrays.copyOfRange(nums, startIndex, endIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}