package src.com.lintcode.l3651;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countComponents(3, new int[][]{{0, 1}, {0, 2}}));
    }

    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    int[] rank;
    int[] parents;

    public int countComponents(int n, int[][] edges) {
        // write your code here
        parents = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        int count = n;
        for (int[] edge : edges) {
            count -= union(edge[0], edge[1]);
        }
        return count;
    }

    public int union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) return 0;
        if (rank[p1] >= rank[p2]) {
            rank[p1] += rank[p2];
            parents[p2] = p1;
        } else {
            rank[p2] += rank[p1];
            parents[p1] = p2;
        }
        return 1;
    }

    public int find(int n) {
        int p = parents[n];
        while (p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }
}