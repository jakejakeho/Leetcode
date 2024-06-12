package src.com.leetcode.s525;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int numOfOne = 0;
        int numOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                numOfOne++;
            } else {
                numOfZero++;
            }

            if (numOfZero == numOfOne) {
                maxLength = Math.max(maxLength, numOfZero + numOfOne);
            }

            if (map.containsKey(numOfOne - numOfZero)) {
                maxLength = Math.max(maxLength, i - map.get(numOfOne - numOfZero));
            } else {
                map.put(numOfOne - numOfZero, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxLength(new int[]{0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0, 1, 0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
        System.out.println(solution.findMaxLength(new int[]{1, 1, 1, 0, 0}));
    }
}