package src.com.leetcode.s128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Boolean> existsMap = new HashMap<>();
        for (int num: nums) {
            existsMap.put(num, true);
        }
        for (int num: nums) {
            if (existsMap.get(num).equals(false))
                continue;
            existsMap.put(num, false);
            int count = 1;
            int left = num - 1;
            int right = num + 1;
            while(existsMap.containsKey(left)) {
                existsMap.put(left, false);
                count++;
                left--;
            }
            while(existsMap.containsKey(right)) {
                existsMap.put(right, false);
                count++;
                right++;
            }
            if (count > result) {
                result = count;
            }
        }
        return result;
    }
}
