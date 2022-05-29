package src.com.leetcode.s3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int longest = 1;
        int leftPointer = 0;
        int rightPointer = 0;
        Set<Character> existSet = new HashSet<>();
        while (rightPointer < s.length()) {
           if (!existSet.contains(s.charAt(rightPointer))) {
               existSet.add(s.charAt(rightPointer));
               rightPointer++;
           } else {
               existSet.remove(s.charAt(leftPointer));
               leftPointer++;
           }
            longest = Math.max(rightPointer - leftPointer, longest);
        }
        return longest;
    }
}