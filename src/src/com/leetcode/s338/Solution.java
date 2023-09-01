package src.com.leetcode.s338;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("expected = 0,1,1" + Arrays.toString(solution.countBits(2)));
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}