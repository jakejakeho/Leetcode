package src.com.leetcode.s217;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i]))
                return true;
            hashSet.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums;
        boolean expected;
        boolean result;
        boolean isCorrect;
        /**
         * Input: nums = [1,2,3,1]
         * Output: true
         */
        nums = new int[] {1, 2, 3, 1};
        expected = true;
        result = solution.containsDuplicate(nums);
        isCorrect = expected == result;

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + result + " expected = " + expected + " correct = " + isCorrect);

    }
}
