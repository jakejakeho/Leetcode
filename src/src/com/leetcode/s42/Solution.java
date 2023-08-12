package src.com.leetcode.s42;

import java.util.Arrays;

class Solution {
    public int trap(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        int maxLeft = height[leftPointer];
        int maxRight = height[rightPointer];

        int total = 0;
        while(leftPointer < rightPointer) {
            int leftHeight = height[leftPointer];
            int rightHeight = height[rightPointer];
            if (leftHeight <= rightHeight) {
                leftPointer++;
                maxLeft = Math.max(height[leftPointer], maxLeft);
                total += maxLeft - height[leftPointer];
            } else {
                rightPointer--;
                maxRight = Math.max(height[rightPointer], maxRight);
                total += maxRight - height[rightPointer];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 2, 0};
        Solution solution = new Solution();
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + solution.trap(height));
    }
}