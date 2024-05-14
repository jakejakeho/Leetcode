package src.com.leetcode.s861;

class Solution {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = grid[i][j] == 1 ? 0 : 1;
                }
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            int numOfZero = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 0) {
                    numOfZero++;
                }
            }
            if (numOfZero > grid.length / 2) {
                for (int i = 0; i < grid.length; i++) {
                    grid[i][j] = grid[i][j] == 1 ? 0 : 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int num = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    num |= (1 << (grid[0].length - 1 - j));
            }
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.matrixScore(new int[][]{
                {0, 0, 1, 1,},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        }));
    }
}