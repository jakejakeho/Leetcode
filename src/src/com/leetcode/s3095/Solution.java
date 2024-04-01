package src.com.leetcode.s3095;

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum | nums[j];
                if (sum >= k) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(solution.minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2}, 0));
    }
}