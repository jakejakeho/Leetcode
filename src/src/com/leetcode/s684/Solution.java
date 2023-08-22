package src.com.leetcode.s684;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][] {{1, 2}, {1, 3}, {2, 3}})));
    }

    public int[] findRedundantConnection(int[][] edges) {
        boolean[][] connected = new boolean[edges.length + 1][edges.length + 1];

        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            if (connected[nodeA][nodeB] && connected[nodeB][nodeA]) {
                return edge;
            } else {
                boolean[] currentConnected = new boolean[edges.length + 1];
                for (int i = 0; i < connected[nodeA].length; i++) {
                    if (connected[nodeA][i]) {
                        currentConnected[i] = true;
                    }
                }
                for (int i = 0; i < connected[nodeB].length; i++) {
                    if (connected[nodeB][i]) {
                        currentConnected[i] = true;
                    }
                }
                currentConnected[nodeA] = true;
                currentConnected[nodeB] = true;
                for (int i = 0; i < currentConnected.length; i++) {
                    if (currentConnected[i]) {
                        connected[i] = currentConnected;
                    }
                }
            }
        }
        return new int[] {};
    }
}