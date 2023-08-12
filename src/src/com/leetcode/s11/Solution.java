package src.com.leetcode.s11;

public class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int currentHeight = Math.min(leftHeight, rightHeight);
            int width = right - left;
            int area = currentHeight * width;
            maxArea = Math.max(area, maxArea);
            if (leftHeight >= rightHeight) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
