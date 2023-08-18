package src.com.leetcode.s1615;

import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int indegree[] = new int[n];
        int haveDirectEdge[][] = new int[n][n];
        for (int i = 0; i < roads.length; i++) {

            int u = roads[i][0];
            int v = roads[i][1];

            indegree[u]++;
            indegree[v]++;

            haveDirectEdge[u][v] = 1;
            haveDirectEdge[v][u] = 1;
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, indegree[i] + indegree[j] - haveDirectEdge[i][j]);
            }
        }
        return ans;
    }
}