package src.com.leetcode.s330;


class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        int i = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss)
                miss += nums[i++];
            else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPatches(new int[]{1, 3}, 6));
        System.out.println(solution.minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(solution.minPatches(new int[]{1, 2, 2}, 5));
    }
}