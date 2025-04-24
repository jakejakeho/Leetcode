package src.com.leetcode150.T2_TwoPointers.Q5_TrappingRainWater;
class Solution {

    public int trap(int[] height) {
        int trappedWater = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                int water = leftMax - height[left];
                if (water > 0) {
                    trappedWater += water;
                }
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                int water = rightMax - height[right];
                if (water > 0) {
                    trappedWater += water;
                }
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}