package src.com.leetcode.s2997;

class Solution {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        for (int  n : nums) {
            finalXor ^= n;
        }
        return Integer.bitCount(finalXor ^ k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{2, 1, 3, 4}, 1));
    }
}