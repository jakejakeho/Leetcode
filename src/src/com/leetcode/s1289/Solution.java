package src.com.leetcode.s1289;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[] lastRow = new int[grid[0].length];
        int[] currentRow = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            lastRow[j] = grid[grid.length - 1][j];
        }

        for (int i = grid.length - 1; i >= 1; i--) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(pair -> pair[1], Comparator.reverseOrder()));
            for (int j = 0; j < grid[0].length; j++) {
                pq.add(new int[]{lastRow[j], j});
                if (pq.size() > 2) {
                    pq.poll();
                }
            }
            PriorityQueue<int[]> tempPq = new PriorityQueue<>(Comparator.comparing(pair -> pair[1]));
            tempPq.addAll(pq);
            List<int[]> smallestTwo = new ArrayList<>(tempPq);
            for (int j = 0; j < grid[0].length; j++) {
                if (smallestTwo.get(0)[1] == j) {
                    currentRow[j] = grid[i - 1][j] + smallestTwo.get(1)[0];
                } else {
                    currentRow[j] = grid[i - 1][j] + smallestTwo.get(0)[0];
                }
            }
            lastRow = currentRow;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            min = Math.min(min, lastRow[j]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
//        System.out.println(solution.minFallingPathSum(new int[][]{
//                {7}
//        }));
//        System.out.println(solution.minFallingPathSum(new int[][]{
//                {2, 2, 1, 2, 2},
//                {2, 2, 1, 2, 2},
//                {2, 2, 1, 2, 2},
//                {2, 2, 1, 2, 2},
//                {2, 2, 1, 2, 2},
//        }));
    }
}