package src.com.leetcode.s713;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int result = 0;
        int product = 1;

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left++];
            }

            result += right - left + 1;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{0, 0}, 1));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 2));
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}