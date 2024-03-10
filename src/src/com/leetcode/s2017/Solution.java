package src.com.leetcode.s2017;


class Solution {
    public long gridGame(int[][] grid) {
        long[] preRow1 = new long[grid[0].length];
        long[] preRow2 = new long[grid[0].length];
        preRow1[0] = grid[0][0];
        preRow2[0] = grid[1][0];
        for (int i = 1; i < grid[0].length; i++) {
            preRow1[i] = grid[0][i] + preRow1[i - 1];
            preRow2[i] = grid[1][i] + preRow2[i - 1];
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            long top = preRow1[preRow1.length - 1] - preRow1[i];
            long bottom = 0;
            if (i > 0) {
                bottom = preRow2[i - 1];
            }
            long robot2Point = Math.max(top, bottom);
            result = Math.min(result, robot2Point);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gridGame(new int[][]{
                {2, 5, 4},
                {1, 5, 1}
        }));
    }
}