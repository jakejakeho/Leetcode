package src.com.leetcode.s867;

import java.util.Arrays;

class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.transpose(new int[][]{
                {2, 4, -1},
                {-10, 5, 11},
                {18, -7, 6}
        })));
    }
}