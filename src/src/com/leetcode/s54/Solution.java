package src.com.leetcode.s54;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int count = 0;
        int i = 0;
        int j = 0;
        int n = matrix.length * matrix[0].length;
        List<Integer> spiralOrders = new ArrayList<>(n);
        int currentDirection = 0;
        while (count < n) {
            spiralOrders.add(matrix[i][j]);
            matrix[i][j] = Integer.MIN_VALUE;
            int nextI = i + directions[currentDirection][0];
            int nextJ = j + directions[currentDirection][1];
            if (nextI >= 0 && nextI < matrix.length && nextJ >= 0 && nextJ < matrix[0].length && matrix[nextI][nextJ] != Integer.MIN_VALUE) {
                i = nextI;
                j = nextJ;
            } else {
                currentDirection = (currentDirection + 1) % directions.length;
                i = i + directions[currentDirection][0];
                j = j + directions[currentDirection][1];
            }
            count++;
        }
        return spiralOrders;
    }
}