package src.com.leetcode.s84;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;
        int start;
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            start = i;
            while(!stack.isEmpty() && stack.peek()[1] > currentHeight) {
                Integer[] pair = stack.pop();
                int index = pair[0];
                int height = pair[1];
                area = Math.max(area, height * (i - index));
                start = index;
            }
            stack.push(new Integer[]{ start, currentHeight });
        }

        while(!stack.isEmpty()) {
            Integer[] pair = stack.pop();
            int index = pair[0];
            int height = pair[1];
            area = Math.max(area, height * (n - index));
        }
        return area;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
