package src.com.leetcode.s33;

import java.util.Arrays;

class Solution {

    public int search(int[] nums, int target) {
        int minIndex = minIndex(nums);
        int k = nums.length - minIndex;
        if (minIndex == 0)
            k = 0;
        if (k == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else {
            if (target >= nums[0] && target <= nums[nums.length - k - 1]) {
                return binarySearch(nums, 0, nums.length - k - 1, target);
            } else {
                return binarySearch(nums, nums.length - k, nums.length - 1, target);
            }
        }
    }

    public int minIndex(int[] nums) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < minValue) {
                minIndex = i;
                minValue = num;
            }
        }
        return minIndex;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        int expected = 4;
        System.out.println(
            "nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = "
                + expected);

        nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        target = 3;
        result = solution.search(nums, target);
        expected = -1;
        System.out.println(
            "nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = "
                + expected);

        nums = new int[] {1};
        target = 0;
        result = solution.search(nums, target);
        expected = -1;
        System.out.println(
            "nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = "
                + expected);

        nums = new int[] {1};
        target = 1;
        result = solution.search(nums, target);
        expected = 0;
        System.out.println(
            "nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = "
                + expected);

        nums = new int[] {1, 3};
        target = 0;
        result = solution.search(nums, target);
        expected = -1;
        System.out.println(
            "nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = "
                + expected);

        nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        target = 0;
        result = solution.search(nums, target);
        expected = 4;
        System.out.println(
            "nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = "
                + expected);
    }
}