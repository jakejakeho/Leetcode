package src.com.leetcode.s1380;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[] maxCol = new int[matrix[0].length];

        for (int j = 0; j < matrix[0].length; j++) {
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            maxCol[j] = max;
        }

        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            if (maxCol[minIndex] == min) {
                result.add(min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.luckyNumbers(new int[][]{
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        }));
    }
}