package src.com.leetcode.s2812;

import java.util.*;

class Solution {

    private int[] roww = {0, 0, -1, 1};
    private int[] coll = {-1, 1, 0, 0};

    private void bfs(List<List<Integer>> grid, int[][] safenessFactor, int n) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    safenessFactor[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1];
            int s = safenessFactor[x][y];

            for (int i = 0; i < 4; i++) {
                int newX = x + roww[i];
                int newY = y + coll[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && safenessFactor[newX][newY] > 1 + s) {
                    safenessFactor[newX][newY] = 1 + s;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] safetyFactors = new int[n][n];
        for (int[] safetyFactor : safetyFactors) Arrays.fill(safetyFactor, Integer.MAX_VALUE);
        bfs(grid, safetyFactors, n);

        boolean[][] visited = new boolean[safetyFactors.length][safetyFactors[0].length];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        queue.offer(new int[]{0, 0, safetyFactors[0][0]});

        while (!queue.isEmpty()) {
            int[] currentCoordinate = queue.poll();
            int currentFactor = currentCoordinate[2];
            int i = currentCoordinate[0], j = currentCoordinate[1];

            if (i == n - 1 && j == n - 1) return currentFactor;
            visited[i][j] = true;

            for (int k = 0; k < 4; k++) {
                int nextI = i + roww[k];
                int nextJ = j + coll[k];

                if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n && !visited[nextI][nextJ]) {
                    int s = Math.min(currentFactor, safetyFactors[nextI][nextJ]);
                    queue.offer(new int[]{nextI, nextJ, s});
                    visited[nextI][nextJ] = true;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.maximumSafenessFactor(List.of(
//                List.of(1, 0, 0),
//                List.of(0, 0, 0),
//                List.of(0, 0, 1))
//        ));
//
//
//        System.out.println(solution.maximumSafenessFactor(List.of(
//                List.of(0, 0, 1),
//                List.of(0, 0, 0),
//                List.of(0, 0, 0)
//        )));
//
//
//        System.out.println(solution.maximumSafenessFactor(List.of(
//                List.of(0, 0, 0, 1),
//                List.of(0, 0, 0, 0),
//                List.of(0, 0, 0, 0),
//                List.of(1, 0, 0, 0)
//        )));
//
//        System.out.println(solution.maximumSafenessFactor(List.of(
//                List.of(0, 1, 1),
//                List.of(1, 1, 1),
//                List.of(1, 1, 0)
//        )));
//
//        System.out.println(solution.maximumSafenessFactor(List.of(
//                List.of(0, 1, 1),
//                List.of(0, 0, 0),
//                List.of(0, 1, 0)
//        )));
//
//        System.out.println(solution.maximumSafenessFactor(List.of(
//                List.of(0, 1, 1),
//                List.of(1, 1, 1),
//                List.of(1, 1, 0)
//        )));
//
//        System.out.println(solution.maximumSafenessFactor(List.of(
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
//                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
//        )));

        System.out.println(solution.maximumSafenessFactor(List.of(
                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                List.of(0, 0, 1, 0, 0, 0, 0, 0, 0, 0),
                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                List.of(0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                List.of(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                List.of(0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
        )));
    }
}