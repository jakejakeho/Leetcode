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
                int target = nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int threeSum = nums[left] + nums[right] + target;
                    if (threeSum > 0) {
                        right--;
                    } else if (threeSum < 0) {
                        left++;
                    } else {
                        result.add(List.of(nums[left], nums[right], target));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while(left < right && nums[right] != nums[right - 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}