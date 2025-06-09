package src.com.leetcode.s329;

import java.util.Arrays;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int longest = Integer.MIN_VALUE;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longest = Math.max(longest, recursion(matrix, cache, i, j));
            }
        }
        return longest;
    }

    // dirs
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int recursion(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int longest = 1;
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[0].length) {
                continue;
            }
            if (matrix[i][j] < matrix[newI][newJ])
                longest = Math.max(longest, 1 + recursion(matrix, cache, i + dir[0], j + dir[1]));
        }
        cache[i][j] = longest;
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}