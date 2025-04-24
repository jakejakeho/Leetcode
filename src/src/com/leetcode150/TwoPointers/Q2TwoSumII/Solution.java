package src.com.leetcode150.TwoPointers.Q2TwoSumII;
import java.util.Arrays;

class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        while (left < numbers.length) {
            int rightIndex = binarySearch(numbers, left + 1, numbers.length - 1, target - numbers[left]);
            if (rightIndex != -1) {
                return new int[] {left + 1, rightIndex + 1};
            }
            left++;
        }
        return new int[] {};
    }

    private int binarySearch(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[] {2, 3, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[] {-1, 0}, -1)));
    }
}