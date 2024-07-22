package src.com.leetcode.s2369;

class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] cache = new Boolean[nums.length];
        return dfs(nums, 0, cache);
    }

    private boolean dfs(int[] nums, int i, Boolean[] cache) {
        if (i >= nums.length) {
            return true;
        }
        if (cache[i] != null) {
            return cache[i];
        }
        cache[i] = false;
        if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            if (dfs(nums, i + 2, cache)) {
                cache[i] = true;
                cache[i + 1] = true;
            }
        }

        if (i + 2 < nums.length && ((nums[i] == nums[i + 1] && nums[i] == nums[i + 2])
                || (nums[i + 1] == (nums[i] + 1) && nums[i + 2] == (nums[i] + 2)))) {
            if (dfs(nums, i + 3, cache)) {
                cache[i] = true;
                cache[i + 1] = true;
                cache[i + 2] = true;
            }
        }

        return cache[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPartition(new int[]{4, 4, 4, 5, 6}));
        System.out.println(solution.validPartition(new int[]{1, 1, 1, 2}));
        System.out.println(solution.validPartition(new int[]{993335, 993336, 993337, 993338, 993339, 993340, 993341}));
        System.out.println(solution.validPartition(new int[]{579611, 579611, 579611, 731172, 731172, 496074, 496074, 496074, 151416, 151416, 151416}));
        System.out.println(solution.validPartition(new int[]{993335, 993336, 993337, 993338, 993339, 993340, 993341}));
    }
}