package src.com.leetcode.s1334;

import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adjacencyList = new ArrayList[n];
        int[][] shortestPath = new int[n][n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
            Arrays.fill(shortestPath[i], Integer.MAX_VALUE);
            shortestPath[i][i] = 0;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int distance = edge[2];
            adjacencyList[from].add(new int[]{to, distance});
            adjacencyList[to].add(new int[]{from, distance});
        }

        for (int i = 0; i < n; i++) {
            dijkstra(adjacencyList, shortestPath[i], i);
        }

        return smallestCity(n, shortestPath, distanceThreshold);
    }

    private int smallestCity(int n, int[][] shortestPath, int distanceThreshold) {
        int minReachable = Integer.MAX_VALUE;
        int minCity = -1;
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && shortestPath[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }
            if (reachable <= minReachable) {
                minReachable = reachable;
                minCity = i;
            }
        }
        return minCity;
    }

    private void dijkstra(List<int[]>[] adjacencyList, int[] shortestPath, int i) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        priorityQueue.add(new int[]{i, 0});
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int to = current[0];
            int distance = current[1];
            if (distance > shortestPath[to]) {
                continue;
            }

            for (int[] edge : adjacencyList[to]) {
                int nextCity = edge[0];
                int nextDistance = edge[1];
                if (shortestPath[nextCity] > distance + nextDistance) {
                    shortestPath[nextCity] = distance + nextDistance;
                    priorityQueue.add(new int[]{nextCity, distance + nextDistance});
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
    }
}