package src.com.leetcode.s3599;

import java.util.Arrays;

class Solution {

    private int[][] cache;
    private int[] nums;

    public int minXor(int[] nums, int k) {
        this.nums = nums;
        cache = new int[nums.length][k + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return recursion(0, k);
    }

    private int recursion(int i, int k) {
        if (k == 0 && i == nums.length) return 0;
        if (k == 0 || i == nums.length) return Integer.MAX_VALUE;
        if (cache[i][k] != -1) return cache[i][k];

        int xor = 0;
        int min = Integer.MAX_VALUE;

        for (int a = i; a < nums.length; a++) {
            xor ^= nums[a];
            int next = recursion(a + 1, k - 1);
            if (next != Integer.MAX_VALUE)
                min = Math.min(min, Math.max(xor, next));
        }
        return cache[i][k] = min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minXor(new int[]{1, 2, 3}, 2));
        System.out.println(solution.minXor(new int[]{2, 3, 3, 2}, 3));
        System.out.println(solution.minXor(new int[]{1, 1, 2, 3, 1}, 2));
    }
}