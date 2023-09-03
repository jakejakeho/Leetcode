package src.com.leetcode.s377;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(solution.combinationSum4(new int[]{9}, 3));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        return dfs(nums, target, cache);
    }

    public int dfs(int[] nums, int target, int[] cache) {
        if (target < 0) {
            return 0;
        }
        if (cache[target] == -1) {
            int numOfWays = 0;
            for (int num : nums) {
                if (target - num >= 0) {
                    numOfWays += dfs(nums, target - num, cache);
                }
            }
            cache[target] = numOfWays;
        }
        return cache[target];
    }
}