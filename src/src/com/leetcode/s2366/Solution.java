package src.com.leetcode.s2366;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumReplacement(new int[]{12, 9, 7, 6, 17, 19, 21}));
    }

    public long minimumReplacement(int[] nums) {
        int minMaxValue = nums[nums.length - 1];
        long operations = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= minMaxValue) {
                minMaxValue = nums[i];
            } else {
                // break
                int numOfParts = nums[i] / minMaxValue;
                if (nums[i] % minMaxValue != 0) {
                    numOfParts++;
                }
                minMaxValue = nums[i] / numOfParts;
                operations += numOfParts - 1;
            }
        }
        return operations;
    }
}