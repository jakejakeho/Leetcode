package src.com.leetcode.s200;

class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visitIsland(grid, i, j)) {
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    public boolean visitIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }

        if (grid[i][j] != '1') {
            return false;
        }
        grid[i][j] = '2';
        // go up
        visitIsland(grid, i - 1, j);
        // go down
        visitIsland(grid, i + 1, j);
        // go left
        visitIsland(grid, i, j - 1);
        // go right
        visitIsland(grid, i, j + 1);
        return true;
    }
}