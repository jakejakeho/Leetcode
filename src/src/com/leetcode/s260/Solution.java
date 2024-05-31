package src.com.leetcode.s260;

import java.util.Arrays;

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
            System.out.println(xor);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{-1, 0})));
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{0, 1})));
    }
}