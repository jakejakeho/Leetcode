package src.com.leetcode.s287;

import java.util.Arrays;

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = 0;
        while(true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
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
