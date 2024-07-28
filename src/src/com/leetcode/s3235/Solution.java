package src.com.leetcode.s3235;

class Solution {
    public boolean canReachCorner(int X, int Y, int[][] circles) {
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canReachCorner(3, 4, new int[][]{{2, 1, 1}}));
        System.out.println(solution.canReachCorner(3, 3, new int[][]{{1, 1, 2}}));
        System.out.println(solution.canReachCorner(3, 3, new int[][]{{2, 1, 1}, {1, 2, 1}}));
    }
}