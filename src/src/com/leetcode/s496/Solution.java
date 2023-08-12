package src.com.leetcode.s496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }

        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int cur : nums2) {
            while (!stack.isEmpty() && cur > stack.peek()) {
                Integer updateValue = stack.pop();
                Integer updateIndex = hashMap.get(updateValue);
                result[updateIndex] = cur;
            }

            if (hashMap.containsKey(cur)) {
                stack.push(cur);
            }
        }
        return result;
    }
}
