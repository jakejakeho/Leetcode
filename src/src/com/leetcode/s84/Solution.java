package src.com.leetcode.s84;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int minHeight = Integer.MAX_VALUE;
        int largestArea = 0;
        for (int i = 0 ; i < heights.length; i++) {
            int width = stack.size() + 1;
            int newMinHegiht = Math.min(heights[i] ,minHeight);
            int newArea = width * newMinHegiht;
            if (newArea > largestArea) {
                minHeight = newMinHegiht;
                largestArea = newArea;
                stack.push(heights[i]);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
