package src.com.leetcode.s743;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> startMap = new HashMap<>();
        for (int[] time : times) {
            int start = time[0];
            List<int[]> list = startMap.getOrDefault(start, new ArrayList<>());
            list.add(time);
            startMap.put(start, list);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        queue.add(new int[]{k, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int start = node[0];
            int currentCost = node[1];
            List<int[]> edges = startMap.getOrDefault(start, Collections.emptyList());
            for (int[] edge : edges) {
                int nextEnd = edge[1];
                int nextCost = currentCost + edge[2];
                if (nextCost < dist[nextEnd]) {
                    dist[nextEnd] = nextCost;
                    queue.offer(new int[]{nextEnd, nextCost});
                }
            }
        }
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }
        return maxDelay;
    }
}