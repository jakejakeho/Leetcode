package src.com.leetcode.s310;

import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new LinkedList<>());
            map.putIfAbsent(edge[1], new LinkedList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int minHeight = Integer.MAX_VALUE;
        Map<Integer, Integer> heightMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(i);
            int height = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Integer current = queue.poll();
                    visited.add(current);
                    for (int neighbour : map.getOrDefault(current, Collections.emptyList()))
                        if (!visited.contains(neighbour)) {
                            queue.offer(neighbour);
                        }
                }
                height++;
                if (height > minHeight) {
                    break;
                }
            }
            minHeight = Math.min(minHeight, height);
            heightMap.put(i, height);
        }


        for (Map.Entry<Integer, Integer> entry : heightMap.entrySet()) {
            if (entry.getValue() == minHeight) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}