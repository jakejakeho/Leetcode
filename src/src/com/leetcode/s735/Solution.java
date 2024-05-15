package src.com.leetcode.s735;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (stack.isEmpty() || ((stack.peek() < 0 && asteroid > 0)
                    || (stack.peek() > 0 && asteroid > 0)
                    || (stack.peek() < 0 && asteroid < 0))) {
                stack.push(asteroid);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                    break;
                } else if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    if (stack.isEmpty() || stack.peek() < 0)
                        stack.push(asteroid);
                } else {
                    break;
                }
            }
        }
        int[] result = new int[stack.size()];
        int index = 0;
        for (Integer num : stack) {
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{-2, -2, 1, -2})));
    }
}