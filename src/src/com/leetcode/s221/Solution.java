package src.com.leetcode.s221;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.maximalSquare(new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1'
        //    ,'1','1','1'}, {'1','0','0','1','0'}}));
        System.out.println(solution.maximalSquare(new char[][]{{'1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1', '0', '0', '0'}, {'0', '1', '1', '1', '1', '0', '0', '0'}}));
    }

    public int maximalSquare(char[][] matrix) {
        int[][] widths = new int[matrix.length][matrix[0].length];

        for (int[] width : widths) {
            Arrays.fill(width, -1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                calcWidths(widths, matrix, i, j);
            }
        }

        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int width = widths[i][j];
                if (width <= maxSize)
                    continue;
                int minWidth = width;
                for (int k = 0; k < width; k++) {
                    if (i + k < matrix.length && widths[i + k][j] > 0) {
                        minWidth = Math.min(minWidth, widths[i + k][j]);
                        int height = k + 1;
                        if (minWidth == height && height > maxSize) {
                            maxSize = height;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return maxSize * maxSize;
    }

    private int calcWidths(int[][] widths, char[][] matrix, int i, int j) {
        if (j < widths[0].length && widths[i][j] == -1) {
            if (matrix[i][j] == '1') {
                widths[i][j] = 1 + calcWidths(widths, matrix, i, j + 1);
            }
            return widths[i][j] == -1 ? 0 : widths[i][j];
        }
        return 0;
    }
}
