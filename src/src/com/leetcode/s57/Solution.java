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
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> resultList = new ArrayList<>();
        boolean isOverlap = false;
        for (int i = 0; i < intervals.length; i++) {
            if (isOverlap(intervals[i], newInterval)) {
                newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
                isOverlap = true;
            } else {
                if (isOverlap) {
                    resultList.add(newInterval);
                    newInterval = null;
                    isOverlap = false;
                }
                resultList.add(intervals[i]);
            }
        }
        if (isOverlap) {
            resultList.add(newInterval);
        } else if (newInterval != null) {
            for (int i = 0; i < resultList.size(); i++) {
                int newStart = newInterval[0];
                int oldStart = resultList.get(i)[0];
                if (newStart < oldStart) {
                    resultList.add(i, newInterval);
                    newInterval = null;
                    break;
                }
            }
            if (newInterval != null) {
                resultList.add(newInterval);
            }
        }
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            int[] interval = resultList.get(i);
            result[i][0] = interval[0];
            result[i][1] = interval[1];
        }
        return result;
    }

    public boolean isOverlap(int[] oldInterval, int[] newInterval) {
        if (newInterval == null) {
            return false;
        }
        int newStartTime = newInterval[0];
        int newEndTime = newInterval[1];
        int oldStartTime = oldInterval[0];
        int oldEndTime = oldInterval[1];
        return (newStartTime >= oldStartTime && newStartTime <= oldEndTime) || (newEndTime >= oldStartTime && newEndTime <= oldEndTime)
                || (oldStartTime >= newStartTime && oldStartTime <= newEndTime) || (oldEndTime >= newStartTime && oldEndTime <= newEndTime);
    }

}