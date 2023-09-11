package src.com.leetcode.s787;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> hashMap = new HashMap<>();
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int cost = flight[2];
            hashMap.computeIfAbsent(start, (key) -> new ArrayList<>());
            hashMap.get(start).add(new int[]{end, cost, 1});
        }

        // new int[]{currentPos, totalCost, stops}
        Queue<int[]> queue = new LinkedList<>();
        for (int[] edge : hashMap.getOrDefault(src, Collections.emptyList())) {
            queue.offer(edge);
        }
        int minCost = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int currentPos = edge[0];
            int totalCost = edge[1];
            int stops = edge[2];
            if (currentPos == dst && stops - 1 <= k) {
                minCost = Math.min(minCost, totalCost);
            }
            if (stops <= k) {
                for (int[] e : hashMap.getOrDefault(currentPos, Collections.emptyList())) {
                    queue.offer(new int[]{e[0], totalCost + e[1], stops + 1});
                }
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
