package src.com.leetcode.s560;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[] {1, 1, 1}, 2));
        System.out.println(solution.subarraySum(new int[] {1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        int numOfSubArray = 0;
        int sum = 0;
        while (l < nums.length && r < nums.length) {
            sum += nums[r];
            if (sum == k) {
                numOfSubArray++;
                sum -= nums[l];
                l++;
                r++;
            }
            else if (sum > k) {
                sum -= nums[l];
                l++;
                r++;
            } else {
                r++;
            }
        }
        return numOfSubArray;
    }
}