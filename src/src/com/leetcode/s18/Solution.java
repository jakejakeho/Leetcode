package src.com.leetcode.s18;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        long averageValue = target / 4;
        if (nums[0] > averageValue || averageValue > nums[nums.length - 1])
            return new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                List<List<Integer>> threeSum = threeSum(nums, target - nums[i], i + 1);
                for (List<Integer> threeIndex : threeSum) {
                    threeIndex.add(nums[i]);
                    result.add(threeIndex);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, long target, int startIndex) {
        List<List<Integer>> result = new ArrayList<>();
        if (startIndex == nums.length) {
            return result;
        }
        long averageValue = target / 3;
        if (nums[startIndex] > averageValue || averageValue > nums[nums.length - 1])
            return new ArrayList<>();
        for (int i = startIndex; i < nums.length - 2; i++) {
            if (i == startIndex || nums[i - 1] != nums[i]) {
                List<List<Integer>> twoSum = twoSum(nums, target - nums[i], i + 1);
                for (List<Integer> twoIndex : twoSum) {
                    twoIndex.add(nums[i]);
                    result.add(twoIndex);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();

        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(new ArrayList<>(List.of((int) target - nums[i], nums[i])));
                }
            }
            s.add((long) nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}