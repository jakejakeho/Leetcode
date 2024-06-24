package src.com.leetcode.s1074;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubmatrixSumTarget(new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0},
        }, 0));
        System.out.println(solution.numSubmatrixSumTarget(new int[][]{
                {1, -1},
                {-1, 1},
        }, 0));
        System.out.println(solution.numSubmatrixSumTarget(new int[][]{
                {904},
        }, 0));
    }
}