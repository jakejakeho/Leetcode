package src.com.leetcode.s11;

public class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
           int width = right - left;
           int minHeight = Math.min(height[left], height[right]);
           maxArea = Math.max(width * minHeight, maxArea);
           if (height[left] >= height[right]) {
               right--;
           } else {
               left++;
           }
        }
        return maxArea;
    }
}
