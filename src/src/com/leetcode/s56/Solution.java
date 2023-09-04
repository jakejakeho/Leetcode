package src.com.leetcode.s56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>(intervals.length);
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (isOverlap(list.get(list.size() - 1), intervals[i])) {
                list.get(list.size() - 1)[0] = Math.min(list.get(list.size() - 1)[0], intervals[i][0]);
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        int[][] result = new int[list.size()][2];
        list.toArray(result);
        return result;
    }

    public boolean isOverlap(int[] interval1, int[] interval2) {
        int s1 = interval1[0];
        int e1 = interval1[1];
        int s2 = interval2[0];
        int e2 = interval2[1];
        return s2 <= e1 && s2 >= s1 || e2 <= e1 && e2 >= s1 || s1 <= e2 && s1 >= s2 || e1 <= e2 && e1 >= s2;
    }
}