package src.com.leetcode.s456;

class Solution {
    public boolean find132pattern(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int min = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max && nums[i] > min) {
                return true;
            }
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(solution.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(solution.find132pattern(new int[]{-1, 3, 2, 0}));
    }
}