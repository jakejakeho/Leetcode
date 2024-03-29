package src.com.leetcode.s523;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int length = 2; length <= nums.length; length++) {
            int total = 0;
            for (int i = 0; i < length; i++) {
                total += nums[i];
            }

            if (total % k == 0) {
                return true;
            }

            int left = 0;
            int right = length;

            while (right < nums.length) {
                total -= nums[left];
                total += nums[right];
                if (total % k == 0) {
                    return true;
                }
                left++;
                right++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
//        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
//        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
    }
}