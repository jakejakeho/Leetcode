package src.com.leetcode.s645;


import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length];
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
            if (count[nums[i] - 1] == 2) {
                duplicate = nums[i];
            }
        }

        int missing = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) {
                missing = i + 1;
            }
        }
        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{2, 2})));
    }
}