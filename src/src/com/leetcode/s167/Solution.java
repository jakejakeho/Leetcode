package src.com.leetcode.s167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int firstPointer = 0;
        int secondPointer = numbers.length - 1;
        while (firstPointer < secondPointer) {
            int sum = numbers[firstPointer] + numbers[secondPointer];

            // found
            if (sum == target) {
                break;
            } else if (sum < target) {
                firstPointer++;
            } else {
                secondPointer--;
            }
        }
        return new int[]{firstPointer + 1, secondPointer + 1};
    }
}
