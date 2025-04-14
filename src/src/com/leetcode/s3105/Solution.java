package src.com.leetcode.s3105;

class Solution {

    public int longestMonotonicSubarray(int[] nums) {
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int last = nums[i];
            int length = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > last) {
                    last = nums[j];
                    length++;
                } else {
                    break;
                }
            }
            longest = Math.max(longest, length);
        }

        for (int i = 0; i < nums.length; i++) {
            int last = nums[i];
            int length = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < last) {
                    last = nums[j];
                    length++;
                } else {
                    break;
                }
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestMonotonicSubarray(new int[] {1, 4, 3, 3, 2}));
        System.out.println(solution.longestMonotonicSubarray(new int[] {3, 3, 3, 3}));
        System.out.println(solution.longestMonotonicSubarray(new int[] {3, 2, 1}));
    }
}