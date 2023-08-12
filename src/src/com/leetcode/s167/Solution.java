package src.com.leetcode.s167;

import java.util.Arrays;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;
        while (leftPointer < rightPointer) {
            int sum = numbers[leftPointer] + numbers[rightPointer] - target;
            if (sum == 0) {
                return new int[]{leftPointer + 1, rightPointer + 1};
            } else if (sum < 0) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();

        System.out.println("Input: numbers = " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(numbers, target)));
    }
}
