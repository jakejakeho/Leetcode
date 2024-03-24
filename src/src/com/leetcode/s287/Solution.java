package src.com.leetcode.s287;

class Solution {
    public int findDuplicate(int[] nums) {
        int slowPointer = nums[0];
        int fastPointer = nums[0];

        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        } while (slowPointer != fastPointer);

        slowPointer = nums[0];

        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }

        return slowPointer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(solution.findDuplicate(nums));
    }
}