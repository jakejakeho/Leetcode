package src.com.leetcode.s1260;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int gridCount = grid.length * grid[0].length;
        k = k % gridCount;
        for (int a = 0; a < k; a++) {
            int temp = grid[grid.length - 1][grid[0].length - 1];
            for (int i = grid.length - 1; i >= 0; i--) {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i != 0 && j == 0) {
                        grid[i][j] = grid[i - 1][grid[0].length - 1];
                    } else {
                        grid[i][j] = grid[i][j - 1];
                    }
                }
            }
            grid[0][0] = temp;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                row.add(grid[i][j]);
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shiftGrid(new int[][] {{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23));
        //System.out.println(solution.shiftGrid(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
    }
}