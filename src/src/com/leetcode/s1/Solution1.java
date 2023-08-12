package src.com.leetcode.s1;

import java.util.HashMap;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (map.containsKey(find)) {
                return new int[] {i, map.get(find)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
