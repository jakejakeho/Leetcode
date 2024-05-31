package src.com.leetcode.s260;

import java.util.Arrays;

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int diff = xor & -xor;
        int another = 0;
        for (int num : nums) {
            if ((diff & num) != 0) {
                another ^= num;
            }
        }
        return new int[]{another, xor ^ another};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{-1, 0})));
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{0, 1})));
    }
}