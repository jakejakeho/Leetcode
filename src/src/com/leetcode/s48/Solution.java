package src.com.leetcode.s48;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public void rotate(int[][] matrix) {
        int numOfRing = Math.max(0, matrix.length - 1);
        for (int i = 0; i < numOfRing; i++) {
            System.out.println("i = " + i);
            for (int x = i; x < (matrix.length - (i + 1)); x++) {
                System.out.println("x = " + x + " i = " + i);
            }
        }
    }
}