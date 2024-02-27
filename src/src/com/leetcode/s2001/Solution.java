package src.com.leetcode.s2001;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.interchangeableRectangles(new int[][] {{4, 8}, {3, 6}, {10, 20}, {15, 30}}));
    }

    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        long result = 0;
        for (int[] rectangle : rectangles) {
            double width = rectangle[0];
            double height = rectangle[1];
            double ratio = width / height;
            if (map.containsKey(ratio)) {
                result += map.get(ratio);
            }
            map.put(ratio, map.getOrDefault(ratio, 0L) + 1);
        }
        return result;
    }
}