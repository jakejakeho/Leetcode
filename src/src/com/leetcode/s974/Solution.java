package src.com.leetcode.s974;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int numOfSubArrays = 0;
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefixSum[nums.length] - prefixSum[i] - prefixSum[j + 1];
                if (sum % k == 0) {
                    numOfSubArrays++;
                }
            }
        }
        return numOfSubArrays;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}