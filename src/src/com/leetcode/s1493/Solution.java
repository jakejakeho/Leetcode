package src.com.leetcode.s1493;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1}));
    }

    public int longestSubarray(int[] nums) {
        int lastZeroPos = -1, longest = 0, n = nums.length;

        for (int leftPointer = 0, rightPointer = 0; rightPointer < n; rightPointer++) {
            if (nums[rightPointer] == 0) {
                if (lastZeroPos == -1)
                    lastZeroPos = rightPointer;
                else {
                    leftPointer = lastZeroPos + 1;
                    lastZeroPos = rightPointer;
                }
            }
            longest = Math.max(rightPointer - leftPointer, longest);
        }
        return longest;
    }
}