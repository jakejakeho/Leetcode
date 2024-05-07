package src.com.leetcode.s85;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] vertical = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int count = 0;
            List<Integer> iIndcies = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == '1') {
                    count++;
                    iIndcies.add(i);
                } else {
                    for (int iIndex : iIndcies) {
                        vertical[iIndex][j] = count;
                    }
                    iIndcies = new ArrayList<>();
                    count = 0;
                }
            }
            for (int iIndex : iIndcies) {
                vertical[iIndex][j] = count;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        }));
    }
}