package src.com.leetcode.s976;

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        int largest = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (isvValidTriangle(nums[i], nums[i - 1], nums[i - 2])) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return largest;
    }


    private boolean isvValidTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(solution.largestPerimeter(new int[]{1, 2, 1, 10}));
    }
}