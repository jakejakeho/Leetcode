package src.com.leetcode.s2373;

import java.util.Arrays;

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] largestLocal = new int[grid.length - 2][grid[0].length - 2];
        int tempI = 0;
        int tempJ = 0;
        for (int i = 1; i <= grid.length - 2; i++) {
            for (int j = 1; j <= grid[0].length - 2; j++) {
                int largest = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        largest = Math.max(largest, grid[k][l]);
                    }
                }
                largestLocal[tempI][tempJ] = largest;
                tempJ++;
            }
            tempI++;
            tempJ = 0;
        }
        return largestLocal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.largestLocal(new int[][]{
                {9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2},
        })));
        System.out.println(Arrays.deepToString(solution.largestLocal(new int[][]{
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,2,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
        })));
    }
}