package src.com.leetcode.s1751;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2) + " expected = " + 7);
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt((int[] e) -> e[0]));
        int[][] dp = new int[k + 1][events.length];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return recursive(events, k, 0, dp);
    }

    private int recursive(int[][] events, int k, int startIndex, int[][] dp) {
        if (k == 0 || startIndex >= events.length) {
            return 0;
        }

        if (dp[k][startIndex] == -1) {
            int nextIndex = bisectRight(events, events[startIndex][1]);
            dp[k][startIndex] = Math.max(recursive(events, k, startIndex + 1, dp), events[startIndex][2] + recursive(events, k - 1, nextIndex, dp));
        }
        return dp[k][startIndex];
    }

    private static int bisectRight(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}