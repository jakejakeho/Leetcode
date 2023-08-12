package src.com.leetcode.s42;

class Solution {
    public int trap(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        int maxLeft = height[leftPointer];
        int maxRight = height[rightPointer];

        int total = 0;
        while(leftPointer < rightPointer) {
         if (height[leftPointer] <= height[rightPointer]) {
             leftPointer++;
             maxLeft = Math.max(maxLeft, height[leftPointer]);
             total += maxLeft - height[leftPointer];
         } else {
             rightPointer--;
             maxRight = Math.max(maxRight, height[rightPointer]);
             total += maxRight - height[rightPointer];
         }
        }
        return total;
    }
}