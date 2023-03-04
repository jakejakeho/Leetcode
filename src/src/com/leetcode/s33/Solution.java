package src.com.leetcode.s33;

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int minIndex = minIndex(nums);
        int leftSearch = binarySearch(nums, 0, minIndex - 1, target);
        int rightSearch = binarySearch(nums, minIndex, nums.length - 1, target);
        if (leftSearch != -1) {
            return leftSearch;
        } else if (rightSearch != -1) {
            return rightSearch;
        }
        return -1;
    }

    public int minIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midLeft = (mid - 1 + nums.length) % nums.length;
            int midRight = (mid + 1) % nums.length;
            if (nums[mid] <= nums[midLeft] && nums[mid] <= nums[midRight]) {
                return mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int binarySearch(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            } else if (midNum < target) {
                start = mid + 1;
            } else {
                end = end - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        int expected = 4;
        System.out.println("nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = " + expected);

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 3;
        result = solution.search(nums, target);
        expected = -1;
        System.out.println("nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = " + expected);

        nums = new int[]{1};
        target = 0;
        result = solution.search(nums, target);
        expected = -1;
        System.out.println("nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = " + expected);

        nums = new int[]{1};
        target = 1;
        result = solution.search(nums, target);
        expected = 0;
        System.out.println("nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = " + expected);

        nums = new int[]{1, 3};
        target = 0;
        result = solution.search(nums, target);
        expected = -1;
        System.out.println("nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = " + expected);

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 0;
        result = solution.search(nums, target);
        expected = 4;
        System.out.println("nums = " + Arrays.toString(nums) + " target = " + target + " result = " + result + " expected = " + expected);
    }
}