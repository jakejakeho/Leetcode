package src.com.leetcode.s48;
import java.util.Arrays;

class Solution {

    public void rotate(int[][] matrix) {
        for (int x = 0; x < matrix.length / 2; x++) {
            int maxT = (matrix.length - x - 1) - (x + 1) + 1;
            for (int t = 0; t < maxT; t++) {
                int i = x;
                int j = x + 1;
                // left top to right top
                int nextPixel = matrix[x][x];
                for (; j < matrix.length - x; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = nextPixel;
                    nextPixel = tmp;
                }
                j--;

                // right top to right bottom
                i++;
                for (; i < matrix.length - x; i++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = nextPixel;
                    nextPixel = tmp;
                }
                i--;

                // right bottom to left bottom
                j--;
                for (; j >= x; j--) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = nextPixel;
                    nextPixel = tmp;
                }
                j++;

                // left bottom to left top
                i--;
                for (; i >= x; i--) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = nextPixel;
                    nextPixel = tmp;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},};
        solution.rotate(result);
        System.out.println(Arrays.deepToString(result));
    }
}