package src.com.leetcode.s66;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            int newDigit = carry + digit;
            if (i == digits.length - 1) {
                newDigit += 1;
            }
            if (newDigit >= 10) {
                newDigit = newDigit % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            digits[i] = newDigit;
        }
        int[] results = digits;
        if (carry == 1) {
            results = new int[digits.length + 1];
            for (int i = 1; i < results.length; i++) {
                results[i] = digits[i - 1];
            }
            results[0] = 1;
        }
        return results;
    }
}