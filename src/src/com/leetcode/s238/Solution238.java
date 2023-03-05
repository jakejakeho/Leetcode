package src.com.leetcode.s238;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            int prefixValue = ((i - 1) < 0) ? 1 : nums[i - 1];
            prefix *= prefixValue;
            result[i] = prefix;
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int postfixValue = ((i + 1) >= nums.length) ? 1 : nums[i + 1];
            postfix *= postfixValue;
            result[i] *= postfix;
        }
        return result;
    }
}
