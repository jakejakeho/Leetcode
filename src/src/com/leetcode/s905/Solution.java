package src.com.leetcode.s905;

import java.util.Arrays;

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int oddIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int temp = nums[oddIndex];
                nums[oddIndex] = nums[i];
                nums[i] = temp;
                i--;
                oddIndex--;
            }
            if (i == oddIndex) {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(solution.sortArrayByParity(new int[]{0})));
    }
}