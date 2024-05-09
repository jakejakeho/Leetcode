package src.com.leetcode.s3075;

import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long max = 0;
        for (int i = 0; i < k; i++) {
            max += Math.max(0, happiness[happiness.length - 1 - i] - i);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumHappinessSum(new int[]{1, 2, 3}, 2));
        System.out.println(solution.maximumHappinessSum(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println(solution.maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
        System.out.println(solution.maximumHappinessSum(new int[]{12, 1, 42}, 3));
    }
}