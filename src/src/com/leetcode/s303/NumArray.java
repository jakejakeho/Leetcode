package src.com.leetcode.s303;

class NumArray {
    int sum = 0;
    int[] nums;
    int[] leftSum;
    int[] rightSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        initalizeLeftSum(nums);
        initalizeRightSum(nums);
    }

    private void initalizeLeftSum(int[] nums) {
        leftSum = new int[nums.length];
        int sum = 0;
        int i = 0;
        for(int num: nums) {
            sum += num;
            leftSum[i++] = sum;
        }
        this.sum = sum;
    }

    private void initalizeRightSum(int[] nums) {
        rightSum = new int[nums.length];
        int sum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            sum += nums[i];
            rightSum[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left < right)
            return sum - getLeftSum(left - 1) - getRightSum(right + 1);
        else if (left == right)
            return nums[left];
        return -87;
    }

    private int getLeftSum(int left) {
        if(left < 0){
            return 0;
        }
        return leftSum[left];
    }

    private int getRightSum(int right){
        if (right > (rightSum.length - 1))
            return 0;
        return rightSum[right];
    }
}