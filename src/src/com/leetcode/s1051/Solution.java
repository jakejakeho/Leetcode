package src.com.leetcode.s1051;

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int unexpected = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                unexpected++;
            }
        }
        return unexpected;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}