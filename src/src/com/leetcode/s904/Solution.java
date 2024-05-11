package src.com.leetcode.s904;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);
            while (countMap.size() > 2) {
                countMap.put(fruits[left], countMap.getOrDefault(fruits[left], 0) - 1);
                if (countMap.get(fruits[left]) == 0) {
                    countMap.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalFruit(new int[]{1, 2, 1}));
        System.out.println(solution.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}