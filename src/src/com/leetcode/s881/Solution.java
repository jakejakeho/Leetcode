package src.com.leetcode.s881;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("expected = 1, result = " + solution.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println("expected = 3, result = " + solution.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println("expected = 4, result = " + solution.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println("expected = 3, result = " + solution.numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            boats++;
            if (left <= right && people[left] <= limit - people[right]) {
                left++;
            }
            right--;
        }
        return boats;
    }
}