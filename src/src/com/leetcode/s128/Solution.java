package src.com.leetcode.s128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, true);
        }

        for (int num: nums) {
            int count = 1;
            int left = num - 1;
            while(hashMap.getOrDefault(left, false)) {
                hashMap.put(left, false);
                count++;
                left--;
            }
            int right = num + 1;
            while(hashMap.getOrDefault(right, false)) {
                hashMap.put(right, false);
                count++;
                right++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
