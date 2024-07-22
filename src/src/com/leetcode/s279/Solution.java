package src.com.leetcode.s279;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    /**
     * 279. Perfect Squares Medium Topics Companies Given an integer n, return the least number of perfect square
     * numbers that sum to n.
     * <p>
     * A perfect square is an integer that is the square of an integer; in other words, it is the product of some
     * integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
     * <p>
     * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
     *
     * @param n
     * @return
     */

    public int numSquares(int n) {
        List<Integer> perfectSquares = generatePerfectSquares(n);
        return dfs(n, perfectSquares);
    }

    private int dfs(int n, List<Integer> perfectSquares) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int ps: perfectSquares) {
                if (i < ps) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - ps] + 1);
            }
        }
        return dp[n];
    }

    public List<Integer> generatePerfectSquares(int n) {
        int lastSquare;
        List<Integer> perfectSquares = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lastSquare = i * i;
            if (lastSquare > n) {
                break;
            }
            perfectSquares.add(lastSquare);
        }
        return perfectSquares;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
        System.out.println(solution.numSquares(1));
    }
}

