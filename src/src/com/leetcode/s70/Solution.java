package src.com.leetcode.s70;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long startTime = System.nanoTime();
        System.out.println(solution.climbStairs(1000000));
        long endTime = System.nanoTime();
        System.out.println("run time = " + (endTime - startTime) + " nanoSeconds");
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}