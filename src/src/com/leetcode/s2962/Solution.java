package src.com.leetcode.s2962;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }
        long count = 0;
        int left = 0;
        for (int num : nums) {
            if (num == maxElement) {
                count++;
            }

            while (count == k) {
                if (nums[left] == maxElement) {
                    count--;
                }
                left++;
            }
            result += left;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
    }
}