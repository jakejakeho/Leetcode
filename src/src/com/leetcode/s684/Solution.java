package src.com.leetcode.s684;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][] {{1, 2}, {1, 3}, {2, 3}})));
    }

    int[] parents;

    int[] rank;

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parents[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parents[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    public int find(int n) {
        int p = parents[n];
        while (p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }

    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        Arrays.fill(rank, 1);

        for (int[] edge : edges) {
            boolean union = union(edge[0], edge[1]);
            if (!union) {
                return edge;
            }
        }
        return null;
    }
}