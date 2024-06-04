package src.com.leetcode.s229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int currentNum = Integer.MIN_VALUE;
        int currentCount = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                currentCount++;
            } else {
                if (currentCount > nums.length / 3) {
                    result.add(currentNum);
                }
                currentNum = nums[i];
                currentCount = 1;
            }
        }
        if (currentCount > nums.length / 3) {
            result.add(nums[nums.length - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution.majorityElement(new int[]{1}));
        System.out.println(solution.majorityElement(new int[]{1, 2}));
        System.out.println(solution.majorityElement(new int[]{2, 2}));
        System.out.println(solution.majorityElement(new int[]{2, 2, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9}));
    }
}