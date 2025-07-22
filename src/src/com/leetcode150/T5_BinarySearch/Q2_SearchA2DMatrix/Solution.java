package src.com.leetcode150.T5_BinarySearch.Q2_SearchA2DMatrix;
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // find row first
        int top = 0;
        int bottom = matrix.length - 1;
        int row = -1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                row = mid;
                break;
            } else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        if (row == -1) {
            return false;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(solution.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}