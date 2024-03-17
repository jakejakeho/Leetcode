package src.com.leetcode.s525;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxLength(new int[]{0, 1}));
    }

    public int findMaxLength(int[] nums) {
        int numOfZero = 0;
        int numOfOne = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                numOfZero++;
            } else if (num == 1) {
                numOfOne++;
            }

            if (!map.containsKey(numOfOne - numOfZero))
                map.put(numOfOne - numOfZero, i);

            if (numOfOne == numOfZero) {
                maxLength = numOfOne + numOfZero;
            } else {
                int index = map.get(numOfOne - numOfZero);
                maxLength = Math.max(maxLength, i - index);
            }
        }
        return maxLength;
    }
}