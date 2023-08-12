package src.com.leetcode.s74;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midI = mid / matrix[0].length;
            int midJ = mid % matrix[0].length;
            if (matrix[midI][midJ] == target) {
                return true;
            } else if (matrix[midI][midJ] > target) {
                // go left
                right = mid - 1;
            } else {
                // go right
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test case 1
        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60},};
        int target = 3;
        boolean result = solution.searchMatrix(matrix, target);
        boolean excepted = true;
        System.out.println(
            "Test case 1 result = " + result + " target = " + target + " excepted = " + excepted + " correct? = " + (
                result == excepted));

        // test case 2
        matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60},};
        target = 13;
        result = solution.searchMatrix(matrix, target);
        excepted = false;
        System.out.println(
            "Test case 2 result = " + result + " target = " + target + " excepted = " + excepted + " correct? = " + (
                result == excepted));

        System.out.println("-------");
        matrix = new int[][] {{1, 1}};
        target = 2;
        result = solution.searchMatrix(matrix, target);
        excepted = false;
        System.out.println(
            "Test case 3 result = " + result + " target = " + target + " excepted = " + excepted + " correct? = " + (
                result == excepted));

    }
}