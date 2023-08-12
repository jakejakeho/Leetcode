package src.com.leetcode.s912;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 2, 3, 1,};
        solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right);
    }

    public void merge(int[] nums, int left, int right) {
        int[] merged = new int[(right - left) + 1];
        int leftPointer = left;
        int mid = (left + right) / 2;
        int rightPointer = mid + 1;

        int mergePointer = 0;
        while (leftPointer <= mid && rightPointer <= right) {
            if (nums[leftPointer] <= nums[rightPointer]) {
                merged[mergePointer] = nums[leftPointer];
                mergePointer++;
                leftPointer++;
            } else {
                merged[mergePointer] = nums[rightPointer];
                mergePointer++;
                rightPointer++;
            }
        }

        while (leftPointer <= mid) {
            merged[mergePointer] = nums[leftPointer];
            mergePointer++;
            leftPointer++;
        }

        while (rightPointer <= right) {
            merged[mergePointer] = nums[rightPointer];
            mergePointer++;
            rightPointer++;
        }

        for (int i = left; i <= right; i++) {
            nums[i] = merged[i - left];
        }
    }
}