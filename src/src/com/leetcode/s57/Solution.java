package src.com.leetcode.s57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(intervals.length);
        Integer min = newInterval[0];
        Integer max = newInterval[1];
        boolean needCombine = false;
        for (int[] interval : intervals) {
            if (overlap(interval, newInterval)) {
                needCombine = true;
                if (min == null)
                    min = Math.min(interval[0], newInterval[0]);
                else
                    min = Math.min(min, Math.min(interval[0], newInterval[0]));
                if (max == null)
                    max = Math.max(interval[1], newInterval[1]);
                else
                    max = Math.max(max, Math.max(interval[1], newInterval[1]));
            } else {
                if (needCombine && min != null) {
                    list.add(new int[]{min, max});
                    min = null;
                    max = null;
                }
                list.add(interval);
            }
        }
        if (min != null) {
            list.add(new int[]{min, max});
        }
        list.sort(Comparator.comparingInt(a -> a[1]));
        int[][] result = new int[list.size()][2];
        int i = 0;
        for (int[] interval : list) {
            result[i++] = interval;
        }
        return result;
    }

    private boolean overlap(int[] interval, int[] newInterval) {
        int start1 = interval[0];
        int end1 = interval[1];
        int start2 = newInterval[0];
        int end2 = newInterval[1];
        boolean isOverlap = start2 <= end1 && start2 >= start1 ||
                end2 >= start1 && end2 <= end1 ||
                start1 <= end2 && start1 >= start2 ||
                end1 >= start2 && end1 <= end2;
        return isOverlap;
    }
}