package src.com.leetcode.s11;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] height = new int[]{1, 3, 2, 5, 25, 24, 5};
        Solution solution = new Solution();
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + solution.maxArea(height));
    }
}
