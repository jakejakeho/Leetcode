package src.com.leetcode.s834;

import java.util.*;

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], (k) -> new HashSet<>());
            map.computeIfAbsent(edge[1], (k) -> new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer()

        for (int j = 0; j < n; j++) {
            Set<Integer> visited = new HashSet<>();
            dp[j] = distance(map, dp, 0, j, visited);
        }


        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j)
                    sum[i] += dp[i][j];
            }
        }
        return sum;
    }

    private int distance(Map<Integer, Set<Integer>> map, int[][] dp, int current, int target, Set<Integer> visited) {
        if (current == target) {
            return 0;
        }
        if (dp[current][target] != -1) {
            return dp[current][target];
        }
        visited.add(current);
        Set<Integer> neighbours = map.getOrDefault(current, Collections.emptySet());
        for (Integer neighbour : neighbours) {
            if (!visited.contains(neighbour)) {

                int nextDistance = distance(map, dp, neighbour, target, visited);
                if (nextDistance != -1) {
                    dp[current][target] = 1 + nextDistance;
                    dp[target][current] = 1 + nextDistance;
                }
            }
        }
        return dp[current][target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
    }
}