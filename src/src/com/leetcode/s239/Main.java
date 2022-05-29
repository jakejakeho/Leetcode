package src.com.leetcode.s239;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums;
        int k;

        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        k = 3;
        System.out.println("Inptut: nums = " + Arrays.toString(nums) + ", k = " + 3);
        System.out.println("Output: " + Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }
}
