package src.com.leetcode.s3232;

class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumSingleDigit = 0;
        int sumDoubleDigit = 0;
        for (int num : nums) {
            if (num < 10) {
                sumSingleDigit += num;
            } else {
                sumDoubleDigit += num;
            }
        }
        return sumSingleDigit != sumDoubleDigit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canAliceWin(new int[]{1, 2, 3, 4, 10}));
    }
}