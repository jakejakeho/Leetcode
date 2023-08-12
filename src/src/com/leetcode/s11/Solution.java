package src.com.leetcode.s11;

import java.util.Arrays;

public class Solution {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        while(leftPointer < rightPointer) {
            int w = rightPointer - leftPointer;
            int h = Math.min(height[leftPointer], height[rightPointer]);
            int area = w * h;
            maxArea = Math.max(area, maxArea);
            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 3, 2, 5, 25, 24, 5};
        Solution solution = new Solution();
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + solution.maxArea(height));
    }
}
