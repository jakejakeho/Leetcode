package src.com.leetcode.s778;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.swimInWater(new int[][] {{0, 2}, {1, 3}}));
    }

    public int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        queue.offer(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int minHeight = element[0];
            int i = element[1];
            int j = element[2];

            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return minHeight;
            }
            for (int[] dir : dirs) {
                int di = dir[0];
                int dj = dir[1];
                int newI = i + di;
                int newJ = j + dj;
                if (newI < 0 || newI == grid.length || newJ < 0 || newJ == grid[0].length || visited[newI][newJ]) {
                    continue;
                }
                visited[newI][newJ] = true;
                queue.offer(new int[] {Math.max(minHeight, grid[newI][newJ]), newI, newJ});
            }
        }
        return -1;
    }
}