package src.com.leetcode.s3341;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[][] best = new int[moveTime.length][moveTime[0].length];
        for (int i = 0; i < best.length; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }
        best[0][0] = 0;
        boolean[][] visited = new boolean[moveTime.length][moveTime[0].length];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] room = pq.poll();
            int x = room[0];
            int y = room[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= moveTime.length || newY < 0 || newY >= moveTime[0].length) {
                    continue;
                }
                int dist = Math.max(best[x][y], moveTime[newX][newY]) + 1;
                if (dist < best[newX][newY]) {
                    best[newX][newY] = dist;
                    pq.offer(new int[]{newX, newY, dist});
                }
            }
        }
        return best[moveTime.length - 1][moveTime[0].length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minTimeToReach(new int[][]{{0, 4}, {4, 4}}));
        System.out.println(solution.minTimeToReach(new int[][]{{0, 0, 0}, {0, 0, 0}}));
        System.out.println(solution.minTimeToReach(new int[][]{{0, 1}, {1, 2}}));
    }
}