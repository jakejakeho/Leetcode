package src.com.lintcode.l663;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static final int EMPTY_ROOM = 2147483647;
    public static final int GATE = 0;

    public static final int WALL = -1;

    public static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rooms = new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647},
        };
        solution.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    public void wallsAndGates(int[][] rooms) {
        // write your code here
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int newI = point[0];
            int newJ = point[1];
            for (int[] dir : dirs) {
                int nextI = newI + dir[0];
                int nextJ = newJ + dir[1];

                if (nextI >= 0 && nextI < rooms.length && nextJ >= 0 && nextJ < rooms[0].length && rooms[nextI][nextJ] == EMPTY_ROOM) {
                    rooms[nextI][nextJ] = rooms[newI][newJ] + 1;
                    queue.offer(new int[]{nextI, nextJ});
                }
            }
        }
    }
}
