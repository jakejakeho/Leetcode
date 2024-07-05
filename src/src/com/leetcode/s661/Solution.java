package src.com.leetcode.s661;

import java.util.Arrays;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int total = 0;
                int size = 0;
                for (int k = Math.max(0, i - 1); k <= Math.min(img.length - 1, i + 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(img[0].length - 1, j + 1); l++) {
                        total += img[k][l];
                        size++;
                    }
                }
                result[i][j] = Math.floorDiv(total, size);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.imageSmoother(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        })));
        System.out.println(Arrays.deepToString(solution.imageSmoother(new int[][]{
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100},
        })));
    }
}