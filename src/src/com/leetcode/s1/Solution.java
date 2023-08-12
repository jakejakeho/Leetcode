package src.com.leetcode.s1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution1 = new Solution();

        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;

        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target + "\nOutput: " + Arrays.toString(solution1.twoSum(nums, target)));
    }
}
