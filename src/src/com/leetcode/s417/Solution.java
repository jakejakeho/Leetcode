package src.com.leetcode.s417;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(
            new int[][] {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }

    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> coordinates = new ArrayList<>();
        Boolean[][] pacificOcean = new Boolean[heights.length][heights[0].length];
        Boolean[][] atlanticOcean = new Boolean[heights.length][heights[0].length];
        for (int j = 0; j < heights[0].length; j++) {
            recursive(heights, 0, j, pacificOcean);
        }
        for (int i = 0; i < heights.length; i++) {
            recursive(heights, i, 0, pacificOcean);
        }
        for (int j = 0; j < heights[0].length; j++) {
            recursive(heights, heights.length - 1, j, atlanticOcean);
        }
        for (int i = 0; i < heights.length; i++) {
            recursive(heights, i, heights[0].length - 1, atlanticOcean);
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (Boolean.TRUE.equals(pacificOcean[i][j]) && Boolean.TRUE.equals(atlanticOcean[i][j])) {
                    coordinates.add(List.of(i, j));
                }
            }
        } return coordinates;
    }

    private void recursive(int[][] heights, int i, int j, Boolean[][] ocean) {
        if (ocean[i][j] == null) {
            ocean[i][j] = true;
            int currentHeight = heights[i][j];
            for (int[] dir : dirs) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if (newI >= 0 && newI < heights.length && newJ >= 0 && newJ < heights[0].length) {
                    int newHeight = heights[newI][newJ];
                    if (newHeight >= currentHeight) {recursive(heights, newI, newJ, ocean);}
                }
            }
        }
    }
}