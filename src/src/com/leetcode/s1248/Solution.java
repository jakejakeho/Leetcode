package src.com.leetcode.s1248;


class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] % 2 == 1 ? 1 : 0;
            prefixSum[i + 1] = sum;
        }

        int numOfSubArrays = 0;
        for (int right = 0; right < prefixSum.length; right++) {
            int left = 0;
            while (left <= right) {
                if (prefixSum[right] - prefixSum[left] == k)
                    numOfSubArrays++;
                left++;

            }
        }
        return numOfSubArrays;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(solution.numberOfSubarrays(new int[]{2, 4, 6}, 1));
        System.out.println(solution.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}