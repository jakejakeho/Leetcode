package src.com.leetcode.s452;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int result = points.length;
        int[] last = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] current = points[i];
            if (current[0] <= last[1]) {
                result -= 1;
                last = new int[]{Math.max(current[0], last[0]), Math.min(current[1], last[1])};
            } else {
                last = current;
            }
        }
        return result;
    }
}