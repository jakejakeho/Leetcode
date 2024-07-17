package src.com.leetcode.s740;

import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxPoint = 0;
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int earn1 = 0;
        int earn2 = 0;
        for (Map.Entry<Integer, Integer> c : countMap.entrySet()) {
            maxPoint = Math.max(maxPoint, earn1 + c.getKey() * c.getValue());
            if (countMap.containsKey(c.getKey() - 1)) {
                maxPoint = Math.max(maxPoint, earn2);
            } else {
                maxPoint = Math.max(maxPoint, earn2 + c.getKey() * c.getValue());
            }
            earn1 = earn2;
            earn2 = maxPoint;

        }
        return maxPoint;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(solution.deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
        System.out.println(solution.deleteAndEarn(new int[]{12, 32, 93, 17, 100, 72, 40, 71, 37, 92, 58, 34, 29, 78, 11, 84, 77, 90, 92, 35, 12, 5, 27, 92, 91, 23, 65, 91, 85, 14, 42, 28, 80, 85, 38, 71, 62, 82, 66, 3, 33, 33, 55, 60, 48, 78, 63, 11, 20, 51, 78, 42, 37, 21, 100, 13, 60, 57, 91, 53, 49, 15, 45, 19, 51, 2, 96, 22, 32, 2, 46, 62, 58, 11, 29, 6, 74, 38, 70, 97, 4, 22, 76, 19, 1, 90, 63, 55, 64, 44, 90, 51, 36, 16, 65, 95, 64, 59, 53, 93}));
        System.out.println(solution.deleteAndEarn(new int[]{3, 1}));
    }
}