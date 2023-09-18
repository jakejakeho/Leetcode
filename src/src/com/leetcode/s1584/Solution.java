package src.com.leetcode.s1584;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostConnectPoints(new int[][] {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;
        int[][] distance = new int[n][n];
        boolean[][] connected = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        return cost;
    }
}