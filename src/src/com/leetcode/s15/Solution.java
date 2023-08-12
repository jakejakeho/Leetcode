package src.com.leetcode.s15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int leftPointer = i + 1;
                int rightPointer = nums.length - 1;
                while (leftPointer < rightPointer) {
                    if (nums[leftPointer] + nums[rightPointer] == target) {
                        result.add(List.of(nums[leftPointer], nums[rightPointer], target));
                        while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                            leftPointer++;
                        }
                        while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                            rightPointer--;
                        }
                        leftPointer++;
                        rightPointer--;
                    } else if (nums[leftPointer] + nums[rightPointer] > target) {
                        rightPointer--;
                    } else {
                        leftPointer++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.threeSum(nums));
    }
}