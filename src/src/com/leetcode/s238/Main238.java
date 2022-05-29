package src.com.leetcode.s238;

import java.util.Arrays;

public class Main238 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Solution238 solution238 = new Solution238();

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(solution238.productExceptSelf(nums)));
    }
}
