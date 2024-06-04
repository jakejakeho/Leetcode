package src.com.leetcode.s799;


class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] row = new double[query_row + 2][query_row + 2];
        row[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double excess = (row[i][j] - 1.0) / 2.0;
                if (excess > 0) {
                    row[i + 1][j] += excess;
                    row[i + 1][j + 1] += excess;
                }
            }
        }
        return Math.min(1, row[query_row][query_glass]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.champagneTower(1, 1, 1));
        System.out.println(solution.champagneTower(2, 1, 1));
        System.out.println(solution.champagneTower(4, 2, 1));
        System.out.println(solution.champagneTower(100000009, 33, 17));
    }
}