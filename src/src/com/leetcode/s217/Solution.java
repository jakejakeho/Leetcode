package src.com.leetcode.s217;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
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
