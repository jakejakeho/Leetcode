package src.com.leetcode.s323;

class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for (int[] edge : edges) {
            result -= union(parent, rank, edge[0], edge[1]);
        }
        return result;
    }

    public int find(int[] parent, int node) {
        int res = node;
        while (res != parent[res]) {
            parent[res] = parent[parent[res]];
            res = parent[res];
        }
        return res;
    }

    public int union(int[] parent, int[] rank, int node1, int node2) {
        int p1 = find(parent, node1);
        int p2 = find(parent, node2);

        if (p1 == p2) {
            return 0;
        }

        if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
        System.out.println(solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
        System.out.println(solution.countComponents(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(solution.countComponents(4, new int[][]{{2, 3}, {1, 2}, {1, 3}}));
    }
}