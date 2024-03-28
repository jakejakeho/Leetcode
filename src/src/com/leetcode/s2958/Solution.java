package src.com.leetcode.s2958;

import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        int result = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);
            while (frequencyMap.get(nums[right]) > k) {
                frequencyMap.put(nums[left], frequencyMap.getOrDefault(nums[left], 0) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
    }
}