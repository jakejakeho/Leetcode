package src.com.leetcode.s3169;

import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> combined = new Stack<>();
        combined.add(meetings[0]);
        for (int i = 1; i < meetings.length; i++) {
            if (isOverlap(meetings[i], combined.peek())) {
                combined.push(merge(meetings[i], combined.pop()));
            } else {
                combined.push(meetings[i]);
            }
        }
        int daysWithoutMeetings = days;
        for (int i = 0; i < combined.size(); i++) {
            int[] meeting = combined.get(i);
            daysWithoutMeetings -= (meeting[1] - meeting[0] + 1);
        }
        return daysWithoutMeetings;
    }

    private boolean isOverlap(int[] range1, int[] range2) {
        return range2[0] >= range1[0] && range2[0] <= range1[1] ||
                range2[1] >= range1[0] && range2[1] <= range1[1] ||
                range1[0] >= range2[0] && range1[0] <= range2[1] ||
                range1[1] >= range2[0] && range1[1] <= range2[1];
    }

    private int[] merge(int[] range1, int[] range2) {
        return new int[]{Math.min(range1[0], range2[0]), Math.max(range1[1], range2[1])};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDays(14,
                new int[][]{
                        {6, 11},
                        {7, 13},
                        {8, 9},
                        {5, 8}, {3, 13}, {11, 13}, {1, 3}, {5, 10}, {8, 13}, {3, 9}}));
    }
}