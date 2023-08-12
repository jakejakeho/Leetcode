package src.com.leetcode.s238;

import java.util.Arrays;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int prefix = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            prefix *= nums[i];
            result[i + 1] *= prefix;
        }

        int suffix = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            suffix *= nums[i];
            result[i - 1] *= suffix;
        }
        return result;
    }
}
