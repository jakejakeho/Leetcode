package src.com.leetcode.s343;
import java.util.Arrays;

class Solution {

    /**
     * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those
     * integers.
     * <p>
     * Return the maximum product you can get.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 2 Output: 1 Explanation: 2 = 1 + 1, 1 × 1 = 1. Example 2:
     * <p>
     * Input: n = 10 Output: 36 Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return dfs(n, cache);
    }

    private int dfs(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }
        if (n <= 3) {
            return n;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * dfs(n - i, cache));
        }
        cache[n] = max;
        return cache[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerBreak(10));
    }
}