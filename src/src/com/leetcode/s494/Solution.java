package src.com.leetcode.s494;
import java.util.HashMap;

class Solution {

    HashMap<String, Integer> dp;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>();
        return recursive(nums, target, 0, 0);
    }

    private int recursive(int[] nums, int target, int i, int sum) {
        if (i >= nums.length) {
            return target == sum ? 1 : 0;
        }
        String key = i + "_" + sum;
        Integer result = dp.get(key);
        if (result != null) {
            return result;
        }
        int current = recursive(nums, target, i + 1, sum + nums[i]) + recursive(nums, target, i + 1, sum - nums[i]);
        dp.put(key, current);
        return current;
    }
}
