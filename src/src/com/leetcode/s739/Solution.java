package src.com.leetcode.s739;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0 ; i < n ; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                Integer[] temp = stack.pop();
                result[temp[1]] = i - temp[1];
            }
            stack.push(new Integer[]{temperatures[i], i});
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        System.out.println("Input: temperatures = " + Arrays.toString(temperatures));
        System.out.println("output: " + Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
}
