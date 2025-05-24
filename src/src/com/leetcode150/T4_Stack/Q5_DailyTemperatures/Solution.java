package src.com.leetcode150.T4_Stack.Q5_DailyTemperatures;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] temps = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                int waitDay = i - index;
                temps[index] = waitDay;
            }
            if (i < temperatures.length - 1 && temperatures[i] < temperatures[i + 1]) {
                temps[i] = 1;
            } else {
                stack.push(i);
            }
        }
        return temps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[] {30, 40, 50, 60})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[] {30, 60, 90})));
    }
}