package src.com.lintcode.l508;

import java.util.Arrays;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        int[] temp = Arrays.copyOf(nums, nums.length);
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        boolean left = true;
        int i = 0;
        while (leftPointer <= rightPointer) {
            if (left) {
                nums[i] = temp[leftPointer];
                leftPointer++;
            } else {
                nums[i] = temp[rightPointer];
                rightPointer--;

            }
            i++;
            left = !left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }
}