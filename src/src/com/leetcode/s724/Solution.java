package src.com.leetcode.s724;

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for(int i = 0; i< nums.length; i++) {
            int leftIndex = i - 1;
            if (leftIndex >= 0){
                leftSum += nums[leftIndex];
            }
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }
}