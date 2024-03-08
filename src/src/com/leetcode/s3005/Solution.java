package src.com.leetcode.s3005;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFrequency = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int newFrequency = countMap.getOrDefault(num, 0) + 1;
            maxFrequency = Math.max(maxFrequency, newFrequency);
            countMap.put(num, newFrequency);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> count : countMap.entrySet()) {
            if (count.getValue() == maxFrequency)
                result += count.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
    }
}