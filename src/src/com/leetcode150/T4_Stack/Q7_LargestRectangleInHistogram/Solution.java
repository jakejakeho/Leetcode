package src.com.leetcode150.T4_Stack.Q7_LargestRectangleInHistogram;
import java.util.Stack;

class Solution {

    public static class Pair {

        int index;

        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" + "index=" + index + ", value=" + value + '}';
        }
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int current = heights[i];
            int minIndex = i;
            // go down
            // pop things
            while (!stack.isEmpty() && stack.peek().value > current) {
                Pair loser = stack.pop();
                minIndex = Math.min(minIndex, loser.index);
                maxArea = Math.max(maxArea, (i - minIndex) * loser.value);
            }
            maxArea = Math.max(maxArea, (i - minIndex) * current);
            stack.push(new Pair(minIndex, current));
        }

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            int width = heights.length - pair.index;
            int height = pair.value;
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    }
}