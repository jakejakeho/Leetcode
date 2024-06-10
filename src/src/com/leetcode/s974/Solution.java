package src.com.leetcode.s974;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        int prefixSum = 0;
        int[] modGroup = new int[k];
        modGroup[0] = 1;
        for (int num : nums) {
            prefixSum = ((prefixSum + num) % k + k) % k;
            result += modGroup[prefixSum];
            modGroup[prefixSum]++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}