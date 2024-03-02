package src.com.leetcode.s977;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int rightPointer = 0;
        while (rightPointer < nums.length && nums[rightPointer] < 0) {
            rightPointer++;
        }

        int leftPointer = rightPointer - 1;
        int currentIndex = 0;
        while (currentIndex < nums.length) {
            int leftVal;
            int rightVal;
            if (leftPointer >= 0) {
                leftVal = nums[leftPointer];
            } else {
                result[currentIndex++] = (int)Math.pow(nums[rightPointer++], 2);
                continue;
            }
            if (rightPointer < nums.length) {
                rightVal = nums[rightPointer];
            } else {
                result[currentIndex++] = (int)Math.pow(nums[leftPointer--], 2);
                continue;
            }
            
            if (Math.abs(leftVal) < Math.abs(rightVal)) {
                result[currentIndex++] = (int)Math.pow(leftVal, 2);
                leftPointer--;
            } else {
                result[currentIndex++] = (int)Math.pow(rightVal, 2);
                rightPointer++;
            }
        }
        return result;
    }
}