package src.com.leetcode.s347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;

        System.out.println("Input: nums = " + Arrays.toString(nums) + " k = " + k);
        System.out.println("Output: " + Arrays.toString(solution.topKFrequent(nums, k)));
    }
}
