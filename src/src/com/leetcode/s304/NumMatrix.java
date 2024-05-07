package src.com.leetcode.s304;

class NumMatrix {

    int[][] sumMap;

    public NumMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                matrix[i][j] = sum;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        sumMap = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0) {
            if (col1 == 0) {
                return sumMap[row2][col2];
            } else {
                return sumMap[row2][col2] - sumMap[row2][col1 - 1];
            }
        } else {
            if (col1 == 0) {
                return sumMap[row2][col2] - sumMap[row1 - 1][col2];
            } else {
                return sumMap[row2][col2] - sumMap[row1 - 1][col2] - (sumMap[row2][col1 - 1] - sumMap[row1 - 1][col1 - 1]);
            }
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */