package src.com.leetcode.s200;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        }));
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    visitAllOne(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void visitAllOne(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';

            // go up
            if (i - 1 >= 0)
                visitAllOne(grid, i - 1, j);

            // go right
            if (j + 1 < grid[0].length)
                visitAllOne(grid, i, j + 1);

            // go down
            if (i + 1 < grid.length)
                visitAllOne(grid, i + 1, j);

            // go left
            if (j - 1 >= 0)
                visitAllOne(grid, i, j - 1);

        }
    }
}
