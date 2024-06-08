package src.com.leetcode.s2870;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int minOperations = 0;
        for (Integer count : countMap.values()) {
            if (count == 1) {
                return -1;
            }
            minOperations += Math.ceilDiv(count, 3);
        }
        return minOperations;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12}));
    }
}