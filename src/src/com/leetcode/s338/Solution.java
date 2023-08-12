package src.com.leetcode.s338;
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            String bits = Integer.toBinaryString(j);
            for (int i = result.length - 1, count = 0; i >= 0 && count < bits.length(); i--, count++) {
                result[i] += bits.charAt(count) - '0';
            }
        }
        return result;
    }
}