package src.com.leetcode.s1496;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int x = 0;
        int y = 0;
        graph.put(0, new HashSet<>());
        graph.get(0).add(0);
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                y += 1;
            } else if (c == 'S') {
                y -= 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'W') {
                x -= 1;
            }
            graph.computeIfAbsent(x, k -> new HashSet<>());
            Set<Integer> set = graph.get(x);
            if (set.contains(y)) {
                return true;
            } else {
                set.add(y);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPathCrossing("NESWW"));
    }
}