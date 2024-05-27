package src.com.leetcode.s552;

import java.util.Arrays;

class Solution {

    int MOD = (int) (Math.pow(10, 9) + 7);

    public int checkRecord(int n) {
        int[][][] memo = new int[n + 1][2][3];
        for (int[][] array2D : memo) {
            for (int[] array1D : array2D) {
                Arrays.fill(array1D, -1);
            }
        }
        return eligibleCombinations(n, 0, 0, memo);
    }

    private int eligibleCombinations(int n, int numOfAbsent, int consecutiveLate, int[][][] memo) {
        if (numOfAbsent >= 2 || consecutiveLate >= 3) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (memo[n][numOfAbsent][consecutiveLate] != -1) {
            return memo[n][numOfAbsent][consecutiveLate];
        }

        int count = eligibleCombinations(n - 1, numOfAbsent, 0, memo) % MOD;

        count = (count + eligibleCombinations(n - 1, numOfAbsent + 1, 0, memo)) % MOD;

        count = (count + eligibleCombinations(n - 1, numOfAbsent, consecutiveLate + 1, memo)) % MOD;

        return memo[n][numOfAbsent][consecutiveLate] = count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkRecord(1));
        System.out.println(solution.checkRecord(2));
        System.out.println(solution.checkRecord(3));
        System.out.println(solution.checkRecord(10101));
    }
}