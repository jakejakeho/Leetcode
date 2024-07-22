package src.com.leetcode.s1856;
import java.util.Stack;

class Solution {

    /**
     * 1856. Maximum Subarray Min-Product Medium Topics Companies Hint The min-product of an array is equal to the
     * minimum value in the array multiplied by the array's sum.
     * <p>
     * For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20. Given an
     * array of integers nums, return the maximum min-product of any non-empty subarray of nums. Since the answer may be
     * large, return it modulo 109 + 7.
     * <p>
     * Note that the min-product should be maximized before performing the modulo operation. Testcases are generated
     * such that the maximum min-product without modulo will fit in a 64-bit signed integer.
     * <p>
     * A subarray is a contiguous part of an array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,2] Output: 14 Explanation: The maximum min-product is achieved with the subarray [2,3,2]
     * (minimum value is 2). 2 * (2+3+2) = 2 * 7 = 14. Example 2:
     * <p>
     * Input: nums = [2,3,3,1,2] Output: 18 Explanation: The maximum min-product is achieved with the subarray [3,3]
     * (minimum value is 3). 3 * (3+3) = 3 * 6 = 18. Example 3:
     * <p>
     * Input: nums = [3,1,5,6,4,2] Output: 60 Explanation: The maximum min-product is achieved with the subarray [5,6,4]
     * (minimum value is 4). 4 * (5+6+4) = 4 * 15 = 60.
     *
     * @param nums
     * @return
     */
    public int maxSumMinProduct(int[] nums) {
        Stack<long[]> monotonicIncreasingStack = new Stack<>();
        long[] pre = new long[nums.length];
        long res = 0, mod = (int)1e9 + 7;
        long sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            pre[i] = sum1;
        }
        for (int i = 0; i < nums.length; i++) {
            int currentIndex = i;
            while (!monotonicIncreasingStack.isEmpty() && nums[i] < monotonicIncreasingStack.peek()[1]) {
                long[] data = monotonicIncreasingStack.pop();
                int start = (int)data[0];
                long value = data[1];
                long sum = pre[i - 1] - ((start - 1) < 0 ? 0 : pre[start - 1]);
                res = Math.max(res, (value * sum));
                currentIndex = start;
            }
            monotonicIncreasingStack.push(new long[] {currentIndex, nums[i]});
        }

        while (!monotonicIncreasingStack.isEmpty()) {
            long[] data = monotonicIncreasingStack.pop();
            int start = (int)data[0];
            long value = data[1];
            long sum = pre[nums.length - 1] - ((start - 1) >= 0 ? pre[start - 1] : 0);
            res = Math.max(res, sum * value);
        }
        return (int)((res + mod) % mod);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumMinProduct(new int[] {1, 2, 3, 2}));
        System.out.println(solution.maxSumMinProduct(new int[] {2, 3, 3, 1, 2}));
        System.out.println(solution.maxSumMinProduct(new int[] {3, 1, 5, 6, 4, 2}));
        System.out.println(solution.maxSumMinProduct(new int[] {2, 5, 4, 2, 4, 5, 3, 1, 2, 4}));
    }
}