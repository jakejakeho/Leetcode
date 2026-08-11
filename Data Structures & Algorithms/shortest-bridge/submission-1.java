class Solution {

    private int[][] dirs = new int[][]{{1, 0}, {0 , 1}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        boolean found = false;
        for (int i = 0 ; i < grid.length; i++) {
            if (found) break;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                   dfs(grid, i, j);
                   found = true;
                   break;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] element = queue.poll();
            int currentI = element[0];
            int currentJ = element[1];
            int length = element[2];
            
            if (grid[currentI][currentJ] == 1) {
                return length - 1;
            }

            for (int[] dir : dirs) {
                int newI = currentI + dir[0];
                int newJ = currentJ + dir[1];
                if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    queue.offer(new int[]{ newI, newJ, length + 1 });
                }
            }
        }
        return 0;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = 2;
        for (int[] d : dirs) dfs(grid, i + d[0], j + d[1]);
    }
}