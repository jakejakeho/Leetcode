package src.com.leetcode.s424;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        Map<Character, Integer> count = new HashMap<>();
        while (rightPointer < s.length()) {
            count.put(s.charAt(rightPointer), count.getOrDefault(s.charAt(rightPointer), 0) + 1);
            Integer maxSize = 0;
            for (Map.Entry<Character, Integer> entry: count.entrySet()) {
                maxSize = Math.max(entry.getValue(), maxSize);
            }
            while ((rightPointer - leftPointer + 1) - maxSize > k) {
                count.put(s.charAt(leftPointer), count.get(s.charAt(leftPointer) )- 1);
                leftPointer++;
            }
            longest = Math.max(longest, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return longest;
    }
}