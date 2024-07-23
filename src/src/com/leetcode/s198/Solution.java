package src.com.leetcode.s198;

class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            int next = (i + 1) < nums.length ? cache[i + 1] : 0;
            int nextNext = (i + 2) < nums.length ? cache[i + 2] : 0;
            cache[i] = Math.max(next, current + nextNext);
        }
        return cache[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }
}