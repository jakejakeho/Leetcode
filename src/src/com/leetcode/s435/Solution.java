package src.com.leetcode.s435;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    Boolean[][] isOverlap;

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]));

        int lastEndTime = Integer.MIN_VALUE;
        int overlap = 0;

        for (int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            if (startTime >= lastEndTime) {
                lastEndTime = endTime;
            } else {
                overlap++;
            }
        }
        return overlap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.isOverlap(new int[] {1, 2}, new int[] {2, 3}));
        System.out.println(solution.eraseOverlapIntervals(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][] {{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][] {{1, 2}, {2, 3}}));
    }
}