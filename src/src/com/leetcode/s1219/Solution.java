package src.com.leetcode.s1219;

class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    max = Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int max = grid[i][j];
        visited[i][j] = true;

        // go up
        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] != 0) {
            max = Math.max(max, grid[i][j] + dfs(grid, i - 1, j, visited));
        }

        // go down
        if (i + 1 < grid.length && !visited[i + 1][j] && grid[i + 1][j] != 0) {
            max = Math.max(max, grid[i][j] + dfs(grid, i + 1, j, visited));
        }

        // go left
        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] != 0) {
            max = Math.max(max, grid[i][j] + dfs(grid, i, j - 1, visited));
        }

        // go up
        if (j + 1 < grid[0].length && !visited[i][j + 1] && grid[i][j + 1] != 0) {
            max = Math.max(max, grid[i][j] + dfs(grid, i, j + 1, visited));
        }

        visited[i][j] = false;
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.getMaximumGold(new int[][]{
//                {0, 6, 0},
//                {5, 8, 7},
//                {0, 9, 0},
//        }));
        System.out.println(solution.getMaximumGold(new int[][]{
                {1, 0, 7, 0, 0, 0},
                {2, 0, 6, 0, 1, 0},
                {3, 5, 6, 7, 4, 2},
                {4, 3, 1, 0, 2, 0},
                {3, 0, 5, 0, 20, 0},
        }));
    }
}