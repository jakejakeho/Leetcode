package src.com.leetcode.s42;

import java.util.Arrays;

import static java.lang.Math.min;

class Solution {

    public int trap(int[] height) {
        int total = 0;

        int leftPointer = 0;
        int rightPointer = height.length - 1;

        int leftMax = height[leftPointer];
        int rightMax = height[rightPointer];

        while (leftPointer < rightPointer) {
            if (leftMax < rightMax) {
                int water = leftMax - height[leftPointer];
                if (water >= 0) {
                    total += water;
                }
                leftPointer++;
                leftMax = Math.max(leftMax, height[leftPointer]);
            } else {
                int water = rightMax - height[rightPointer];
                if (water >= 0) {
                    total += water;
                }
                rightPointer--;
                rightMax = Math.max(rightMax, height[rightPointer]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution solution = new Solution();
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + solution.trap(height));
    }
}