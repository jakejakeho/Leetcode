package src.com.leetcode.s167;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] numbers = new int[]{ -1, 0 };
        int target = -1;
        Solution solution = new Solution();

        System.out.println("Input: numbers = " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(numbers, target)));
    }
}
