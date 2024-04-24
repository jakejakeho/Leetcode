package src.com.leetcode.s310;

import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                centroids.add(i);
            }
            return centroids;
        }

        ArrayList<Set<Integer>> neighbors = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            neighbors.add(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                Integer neighbor = neighbors.get(leaf).iterator().next();
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinHeightTrees(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}));
    }
}