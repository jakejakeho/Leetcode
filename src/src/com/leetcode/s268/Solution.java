package src.com.leetcode.s268;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[] {3, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int n = nums.length, sum = (int)(((0.0 + n) / 2.0) * (1.0 + n));
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}