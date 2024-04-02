package src.com.leetcode.s1968;

import java.util.Arrays;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        for (int i = 1; i < nums.length - 1; ) {
            if ((nums[i - 1] + nums[i + 1])  == 2 * nums[i]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                if (i > 1) i--;
            } else {
                i++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.rearrangeArray(new int[]{0, 12, 8, 14, 9, 13, 17, 15})));
    }
}