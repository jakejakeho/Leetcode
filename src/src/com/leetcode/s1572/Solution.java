package src.com.leetcode.s1572;

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        // primary diagonal
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][i] != -1) {
                sum += mat[i][i];
                mat[i][i] = -1;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mat.length - 1 - i] != -1) {
                sum += mat[i][mat.length - 1 - i];
                mat[i][mat.length - 1 - i] = -1;
            }
        }
        return sum;
    }
}