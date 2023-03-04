package src.com.leetcode.s74;
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // find vertical first
        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = rows * columns;
        while(high > low) {
            int mid = (low + high) / 2;
            int midElement = matrix[mid / columns][mid % columns];
            if (midElement ==  target) {
                return true;
            } else if (target > midElement) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test case 1
        int[][] matrix = new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60},
        };
        int target = 3;
        boolean result = solution.searchMatrix(matrix, target);
        boolean excepted = true;
        System.out.println("Test case 1 result = " + result + " target = " + target + " excepted = " + excepted + " correct? = " + (result == excepted));


        // test case 2
        matrix = new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60},
        };
        target = 13;
        result = solution.searchMatrix(matrix, target);
        excepted = false;
        System.out.println("Test case 2 result = " + result + " target = " + target + " excepted = " + excepted + " correct? = " + (result == excepted));
    }
}