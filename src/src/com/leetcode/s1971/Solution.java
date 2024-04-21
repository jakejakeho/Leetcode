package src.com.leetcode.s1971;

import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            map.putIfAbsent(s, new LinkedList<>());
            map.putIfAbsent(d, new LinkedList<>());
            map.get(s).add(d);
            map.get(d).add(s);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        if (map.containsKey(source)) {
            queue.addAll(map.get(source));
            visited.add(source);
        }
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (current == destination) {
                return true;
            }
            if (!visited.contains(current) && map.containsKey(current))
                queue.addAll(map.get(current));
            visited.add(current);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPath(10, new int[][]{
                {0, 7},
                {0, 8},
                {6, 1},
                {2, 0},
                {0, 4},
                {5, 8},
                {4, 7},
                {1, 3},
                {3, 5},
                {6, 5},
        }, 7, 5));
    }
}