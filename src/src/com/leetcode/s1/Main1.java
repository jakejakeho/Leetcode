package src.com.leetcode.s1;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] nums = { -1,-2,-3,-4,-5 };
        Integer target = -8;

        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target + "\nOutput: " + Arrays.toString(solution1.twoSum(nums, target)));
    }
}
