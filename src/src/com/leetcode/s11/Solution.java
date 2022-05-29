package src.com.leetcode.s11;

public class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (leftPointer < rightPointer) {
            maxArea = Math.max(maxArea, (rightPointer - leftPointer) * Math.min(height[leftPointer], height[rightPointer]));
            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxArea;
    }
}
