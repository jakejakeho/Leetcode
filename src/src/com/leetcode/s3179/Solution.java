package src.com.leetcode.s3179;

import java.util.Arrays;

class Solution {

    private int MOD = (int) Math.pow(10, 9) + 7;

    public int valueAfterKSeconds(int n, int k) {
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < n; j++) {
                result[j] = (result[j] + result[j - 1]) % MOD;
            }
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.valueAfterKSeconds(4, 5));
        System.out.println(solution.valueAfterKSeconds(5, 3));
    }
}