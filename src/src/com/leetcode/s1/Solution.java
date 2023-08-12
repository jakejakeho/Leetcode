package src.com.leetcode.s1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> existsMap = new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            if (existsMap.containsKey(nums[i])) {
                return new int[]{i, existsMap.get(nums[i])};
            }
            existsMap.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution1 = new Solution();

        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;

        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target + "\nOutput: " + Arrays.toString(solution1.twoSum(nums, target)));
    }
}
