package src.com.leetcode.s42;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        Solution solution = new Solution();
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + solution.trap(height));
    }
}
