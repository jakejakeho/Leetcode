package src.com.leetcode.s63;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        memo[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
        return recursive(obstacleGrid, 0, 0, memo);
    }

    public int recursive(int[][] obstacleGrid, int i, int j, int[][] memo) {
        if (i >= obstacleGrid.length && j >= obstacleGrid[0].length) {
            return 0;
        }
        if (i <= obstacleGrid.length - 1 && j <= obstacleGrid[0].length - 1) {
            if (memo[i][j] != -1) {
                return memo[i][j];
            } else if (obstacleGrid[i][j] != 1) {
                int down = recursive(obstacleGrid, i + 1, j, memo);
                int right = recursive(obstacleGrid, i, j + 1, memo);
                memo[i][j] = down + right;
                return memo[i][j];
            }
        }
        return 0;
    }
}
