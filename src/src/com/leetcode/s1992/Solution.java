package src.com.leetcode.s1992;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] coordinates = new int[]{i, j, 0, 0};
                    markVisited(land, coordinates, i, j);
                    list.add(coordinates);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public void markVisited(int[][] land, int[] coordinates, int i, int j) {
        int height = 0;
        int tmpI = i;
        while (tmpI < land.length && land[tmpI][j] == 1) {
            height++;
            tmpI++;
        }

        int width = 0;
        int tmpJ = j;
        while (tmpJ < land[0].length && land[i][tmpJ] == 1) {
            width++;
            tmpJ++;
        }

        for (tmpI = i; tmpI < i + height; tmpI++) {
            for (tmpJ = j; tmpJ < j + width; tmpJ++) {
                land[tmpI][tmpJ] = 0;
            }
        }
        coordinates[2] = i + height - 1;
        coordinates[3] = j + width - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] land1 = new int[][]{
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1},
        };
        System.out.println(Arrays.deepToString(solution.findFarmland(land1)));
        int[][] land = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        System.out.println(Arrays.deepToString(solution.findFarmland(land)));
    }
}