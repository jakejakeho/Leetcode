package src.com.leetcode.s994;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));
    }

    public int orangesRotting(int[][] grid) {
        int timeUnit = 0;
        int freshOrange;
        do {
            freshOrange = 0;
            int polluted = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    polluted += polluteOrange(grid, i, j);
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }
                    if (grid[i][j] == 1) {
                        freshOrange++;
                    }
                }
            }
            if (polluted == 0 && freshOrange >= 1) {
                return -1;
            }
            if (polluted > 0 || freshOrange > 0) {
                timeUnit++;
            }
        } while (freshOrange > 0);
        return timeUnit;
    }

    public int polluteOrange(int[][] grid, int i, int j) {
        int polluted = 0;
        if (grid[i][j] == 2) {
            // up
            polluted += pollute(grid, i - 1, j);
            // down
            polluted += pollute(grid, i + 1, j);
            // right
            polluted += pollute(grid, i, j + 1);
            // left
            polluted += pollute(grid, i, j - 1);
        }
        return polluted;
    }

    public int pollute(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 3;
            return 1;
        }
        return 0;
    }
}