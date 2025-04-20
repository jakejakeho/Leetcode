package src.com.leetcode.s1769;

import java.util.Arrays;

class Solution {
    public int[] minOperations(String boxes) {
        int[] leftToRight = new int[boxes.length()];
        int count = 0;
        int operations = 0;
        for (int i = 0; i < boxes.length(); i++) {
            operations += count;
            leftToRight[i] = operations;
            if (boxes.charAt(i) == '1') {
                count++;
            }
        }

        int[] rightToLeft = new int[boxes.length()];
        count = 0;
        operations = 0;
        for (int i = boxes.length() - 1; i >= 0; i--) {
            operations += count;
            rightToLeft[i] = operations;
            if (boxes.charAt(i) == '1') {
                count++;
            }
        }

        int[] result = new int[boxes.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = leftToRight[i] + rightToLeft[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.minOperations("110")));
        System.out.println(Arrays.toString(solution.minOperations("001011")));
    }
}