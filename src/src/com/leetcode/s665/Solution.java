package src.com.leetcode.s665;
class Solution {

    public boolean checkPossibility(int[] nums) {
        int numOfNotOk = 0;
        int currentMax = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < currentMax || nums[i] < nums[i - 1]) {
                numOfNotOk++;
            } else {
                currentMax = Math.max(currentMax, nums[i]);
            }
        }
        if (numOfNotOk <= 1) {
            return true;
        }
        numOfNotOk = 0;
        int currentMin = Integer.MAX_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > currentMin || nums[i] > nums[i + 1]) {
                numOfNotOk++;
                if (numOfNotOk > 1) {
                    return false;
                }
            } else {
                currentMin = Math.min(currentMin, nums[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("expected true = " + solution.checkPossibility(new int[] {4, 2, 3}));
        System.out.println("expected false = " + solution.checkPossibility(new int[] {4, 2, 1}));
        System.out.println("expected true = " + solution.checkPossibility(new int[] {5, 7, 1, 8}));
        System.out.println("expected false = " + solution.checkPossibility(new int[] {3, 4, 2, 3}));
        System.out.println("expected true = " + solution.checkPossibility(new int[] {1, 1, 1, 1}));
    }
}