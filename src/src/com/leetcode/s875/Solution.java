package src.com.leetcode.s875;

import java.util.Arrays;

public class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test case 1
        int[] piles = new int[]{ 3, 6, 7, 11};
        int h = 8;
        int result = solution.minEatingSpeed(piles, h);
        int expected = 4;
        boolean isCorrect = result == expected;
        String isCorrectStr = isCorrect ? "Yes" : "No";
        System.out.println("piles = " + Arrays.toString(piles) + " h = " + h + " result = " + result + "expected = " + expected + " correct = " + isCorrectStr);

        // test case 2
        piles = new int[]{ 30, 11, 23, 4, 20};
        h = 5;
        result = solution.minEatingSpeed(piles, h);
        expected = 30;
        isCorrect = result == expected;
        isCorrectStr = isCorrect ? "Yes" : "No";
        System.out.println("piles = " + Arrays.toString(piles) + " h = " + h + " result = " + result + "expected = " + expected + " correct = " + isCorrectStr);

        // test case 3
        piles = new int[]{ 30, 11, 23, 4, 20};
        h = 6;
        result = solution.minEatingSpeed(piles, h);
        expected = 23;
        isCorrect = result == expected;
        isCorrectStr = isCorrect ? "Yes" : "No";
        System.out.println("piles = " + Arrays.toString(piles) + " h = " + h + " result = " + result + "expected = " + expected + " correct = " + isCorrectStr);
    }
}

