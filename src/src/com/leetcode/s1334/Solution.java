package src.com.leetcode.s1334;

import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adjacencyList = new ArrayList[n];
        int[][] shortestPathMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adjacencyList[from].add(new int[]{to, weight});
            adjacencyList[to].add(new int[]{from, weight});
        }

        for (int i = 0; i < n; i++) {
            dijkstra(n, adjacencyList, shortestPathMatrix[i], i);
        }
        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }

    private int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int minReachable = Integer.MAX_VALUE;
        int minCity = -1;
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < shortestPathMatrix[i].length; j++) {
                if (i != j) {
                    int shortestDistance = shortestPathMatrix[i][j];
                    if (shortestDistance <= distanceThreshold) {
                        reachable++;
                    }
                }
            }
            if (reachable <= minReachable) {
                minReachable = reachable;
                minCity = i;
            }
        }
        return minCity;
    }

    private void dijkstra(int n, List<int[]>[] adjacencyList, int[] shortestPathMatrix, int i) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        priorityQueue.add(new int[]{i, 0});
        Arrays.fill(shortestPathMatrix, Integer.MAX_VALUE);
        ;
        shortestPathMatrix[i] = 0;
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentCity = current[0];
            int distance = current[1];
            if (distance > shortestPathMatrix[currentCity]) {
                continue;
            }

            for (int[] neighbour : adjacencyList[currentCity]) {
                int neighbourCity = neighbour[0];
                int weight = neighbour[1];
                if (shortestPathMatrix[neighbourCity] > distance + weight) {
                    shortestPathMatrix[neighbourCity] = distance + weight;
                    priorityQueue.add(new int[]{neighbourCity, shortestPathMatrix[neighbourCity]});
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
    }
}