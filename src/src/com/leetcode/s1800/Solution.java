package src.com.leetcode.s1800;
class Solution {

    public int maxAscendingSum(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int last = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > last) {
                    last = nums[j];
                    sum += nums[j];
                } else {
                    break;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxAscendingSum(new int[] {10, 20, 30, 5, 10, 50}));
        System.out.println(solution.maxAscendingSum(new int[] {10, 20, 30, 40, 50}));
        System.out.println(solution.maxAscendingSum(new int[] {12, 17, 15, 13, 10, 11, 12}));
    }
}