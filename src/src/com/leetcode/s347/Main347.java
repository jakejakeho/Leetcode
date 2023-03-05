package src.com.leetcode.s347;

import java.util.Arrays;

public class Main347 {

    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;

        System.out.println("Input: nums = " + Arrays.toString(nums) + " k = " + k);
        System.out.println("Output: " + Arrays.toString(solution347.topKFrequent(nums, k)));
    }
}
