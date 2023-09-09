package src.com.leetcode.s377;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution.combinationSum4(new int[]{9}, 3));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        cache[0] = 1;
        for (int i = 1; i < cache.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    cache[i] += cache[i - num];
                }
            }
        }
        return cache[target];
    }
}