package src.com.leetcode.s153;

import java.util.Arrays;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test case 1
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int result = solution.findMin(nums);
        int expected = 1;
        boolean correct = result == expected;
        System.out.println("Test case 1 nums = " + Arrays.toString(nums) + " result = " + result + " expected = " + expected + " correct = " + correct);

        // test case 2
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        result = solution.findMin(nums);
        expected = 0;
        correct = result == expected;
        System.out.println("Test case 2 nums = " + Arrays.toString(nums) + " result = " + result + " expected = " + expected + " correct = " + correct);

        // test case 3
        nums = new int[]{11, 13, 15, 17};
        result = solution.findMin(nums);
        expected = 11;
        correct = result == expected;
        System.out.println("Test case 3 nums = " + Arrays.toString(nums) + " result = " + result + " expected = " + expected + " correct = " + correct);
    }
}
