package src.com.leetcode.s70;

import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(10));
    }
}