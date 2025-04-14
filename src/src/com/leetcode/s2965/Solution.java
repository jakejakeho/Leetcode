package src.com.leetcode.s2965;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int[] result = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (set.contains(grid[i][j])) {
                    result[0] = grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }
        for (int i = 1; i <= grid.length * grid.length; i++) {
            if (!set.contains(i)) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findMissingAndRepeatedValues(new int[][] {{1, 3}, {2, 2}})));
        System.out.println(
            Arrays.toString(solution.findMissingAndRepeatedValues(new int[][] {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}})));
    }
}