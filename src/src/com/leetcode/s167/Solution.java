package src.com.leetcode.s167;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right] - target;
            if (sum == 0) {
                return new int[] {left + 1, right + 1};
            }
            else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
