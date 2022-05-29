package src.com.leetcode.s238;

import java.util.Arrays;

public class Solution238 {

    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        Arrays.fill(results, 1);

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            results[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] *= postfix;
            postfix *= nums[i];
        }

        return results;
    }
}
