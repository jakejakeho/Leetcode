package src.com.leetcode.s494;
import java.util.HashMap;

class Solution {

    HashMap<String, Integer> dp;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        dp = new HashMap<>();
        return recursive(nums, target, 0, sum);
    }

    private int recursive(int[] nums, int target, int i, int sum) {
        if (i >= nums.length) {
            return sum == target ? 1 : 0;
        }
        int count;
        String cacheKey = i + "_" + sum;
        if (dp.containsKey(cacheKey)) {
            return dp.get(cacheKey);
        }
        count = recursive(nums, target, i + 1, sum + nums[i]) + recursive(nums, target, i + 1, sum - nums[i]);
        dp.put(cacheKey, count);
        return count;
    }
}
