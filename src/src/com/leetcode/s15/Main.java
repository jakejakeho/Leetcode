package src.com.leetcode.s15;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.threeSum(nums));
    }
}
