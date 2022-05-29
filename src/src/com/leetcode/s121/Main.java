package src.com.leetcode.s121;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        Solution solution = new Solution();
        System.out.println("Input: " + Arrays.toString(prices));
        System.out.println("Output: " + solution.maxProfit(prices));
    }
}
