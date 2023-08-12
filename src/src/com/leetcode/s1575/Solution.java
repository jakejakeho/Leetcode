package src.com.leetcode.s1575;

import java.util.Arrays;

public class Solution {

    private static final int MOD = (int)Math.pow(10, 9) + 7;

    private int[][] cache;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5));
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        cache = new int[locations.length][fuel + 1];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    public int dfs(int[] locations, int cur, int goal, int fuel) {
        if (fuel < 0) {
            return 0;
        }

        if (cache[cur][fuel] != -1) {
            return cache[cur][fuel];
        }

        int result = 0;
        if (cur == goal) {
            result++;
        }

        for (int i = 0; i < locations.length; i++) {
            if (i == cur) continue;
            int cost = Math.abs(locations[i] - locations[cur]);
            result += dfs(locations, i, goal, fuel - cost);
            result %= MOD;
        }

        cache[cur][fuel] = result;

        return result;
    }
}