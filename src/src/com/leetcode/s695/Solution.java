package src.com.leetcode.s695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = area(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int area(int[][] grid, int i, int j) {
        int area = 0;

        if (grid[i][j] == 1) {
            area += 1;
            grid[i][j] = 0;
        }

        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            // go up
            area += area(grid, i - 1, j);
        }

        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            // go down
            area += area(grid, i + 1, j);
        }


        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            // go left
            area += area(grid, i, j - 1);
        }

        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            // go right
            area += area(grid, i, j + 1);
        }

        return area;
    }
}
