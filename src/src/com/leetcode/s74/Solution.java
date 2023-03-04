package src.com.leetcode.s74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numOfElements = matrix.length * matrix[0].length;
        int left = 0;
        int right = numOfElements - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
                return true;
            } else if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
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