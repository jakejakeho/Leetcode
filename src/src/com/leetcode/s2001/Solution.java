package src.com.leetcode.s2001;

import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.interchangeableRectangles(new int[][]{{4, 8}, {3, 6}, {10, 20}, {15, 30}}));
    }

    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> count = new HashMap<>();
        for (int[] rectangle : rectangles) {
            Double hashKey = (rectangle[0] + 0.0) / rectangle[1];
            count.putIfAbsent(hashKey, 0);
            count.computeIfPresent(hashKey, (key, value) -> ++value);
        }

        long result = 0;
        for (long currentCount : count.values()) {
            result += (currentCount * (currentCount - 1)) / 2;
        }
        return result;
    }
}