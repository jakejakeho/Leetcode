package src.com.leetcode.s27;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int numberOfRemoved = 0;
        outerLoop:
        for (int i = 0; i < nums.length - numberOfRemoved; i++) {
            if (nums[i] == val) {
                while (i != nums.length - 1 - numberOfRemoved && nums[nums.length - 1 - numberOfRemoved] == val) {
                    numberOfRemoved++;
                    if (nums.length - 1 - numberOfRemoved < 0)
                        break outerLoop;
                }
                int temp = nums[nums.length - 1 - numberOfRemoved];
                nums[nums.length - 1 - numberOfRemoved] = val;
                nums[i] = temp;
                numberOfRemoved++;
                i--;
            }
        }
        return nums.length - numberOfRemoved;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{4, 5};
        System.out.println(solution.removeElement(arr, 5));
        System.out.println(Arrays.toString(arr));
    }
}