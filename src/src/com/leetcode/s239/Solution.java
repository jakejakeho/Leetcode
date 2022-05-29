package src.com.leetcode.s239;

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return nums;
        }
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];

        int windowStart = 0;

        Deque<Integer> deque = new ArrayDeque();
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            while(!deque.isEmpty() && nums[windowEnd] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(windowEnd);
            if (windowStart > deque.getFirst()) {
                deque.removeFirst();
            }

            if ((windowEnd - windowStart + 1) >= k) {
                result[windowStart] = nums[deque.getFirst()];
                windowStart++;
            }
        }

        return result;
    }
}