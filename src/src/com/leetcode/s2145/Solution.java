package src.com.leetcode.s2145;

import java.util.Arrays;

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long[] baseSequence = new long[differences.length + 1];
        long max = 0;
        long min = 0;
        for (int i = 0; i < differences.length; i++) {
            baseSequence[i + 1] = differences[i] + baseSequence[i];
            max = Math.max(max, baseSequence[i + 1]);
            min = Math.min(min, baseSequence[i + 1]);
            long diffMaxMin = Math.abs(max - min);
            long diffLowerUpper = Math.abs(upper - lower);

            if (diffMaxMin > diffLowerUpper) {
                return 0;
            }
        }

        long adjustment = lower - min;
        long adjustedMax = max + adjustment;
        return Math.toIntExact(upper - adjustedMax + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArrays(new int[]{1, -3, 4}, 1, 6));
        System.out.println(solution.numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5));
        System.out.println(solution.numberOfArrays(new int[]{4, -7, 2}, 3, 6));
        int[] testcase = new int[10000];
        Arrays.fill(testcase, 100000);
        System.out.println(solution.numberOfArrays(testcase, -100000, 100000));
    }
}