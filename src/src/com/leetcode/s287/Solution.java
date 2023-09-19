package src.com.leetcode.s287;

import java.util.Arrays;

public class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = 0, hare = 0;
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(nums[tortoise] != nums[hare]);

        int p1 = 0, p2 = tortoise;
        while (nums[p1] != nums[p2]) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return nums[p1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        /**
         * Input: nums = [1,3,4,2,2]
         * Output: 2
         */

        nums = new int[]{1, 3, 4, 2, 2};
        System.out.println("Output = " + solution.findDuplicate(nums));
    }
}
