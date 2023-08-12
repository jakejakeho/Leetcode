package src.com.leetcode.s2090;
import java.util.Arrays;

class Solution {

    private long[] leftSum;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(
            solution.getAverages(new int[] {40527, 53696, 10730, 66491, 62141, 83909, 78635, 18560}, 2)));
    }

    public int[] getAverages(int[] nums, int k) {
        initalize(nums);
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            if (k == 0) {
                result[i] = nums[i];
            } else {
                int startIndex = i - k;
                int endIndex = i + k;

                if (startIndex >= 0 && startIndex < nums.length && endIndex >= 0 && endIndex < nums.length) {
                    long sum = getSum(startIndex, endIndex);
                    result[i] = (int)(sum / (long)(endIndex - startIndex + 1));

                }
            }
        }
        return result;
    }

    private void initalize(int[] nums) {
        leftSum = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            leftSum[i] = sum;
        }
    }

    private long getSum(int startIndex, int endIndex) {
        int leftSumIndex = startIndex - 1;
        long leftSum = 0;
        if (leftSumIndex >= 0) {
            leftSum = this.leftSum[leftSumIndex];
        }

        long rightSum = 0;
        if (endIndex <= (this.leftSum.length - 1)) {
            rightSum = this.leftSum[endIndex];
        }

        return rightSum - leftSum;
    }
}
