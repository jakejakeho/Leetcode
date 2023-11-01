package src.com.leetcode.s3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "dvdf";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int leftPointer = 0;
        int rightPointer = 0;
        int longest = 0;
        Map<Character, Integer> used = new HashMap<>();
        while (leftPointer <= rightPointer && rightPointer < s.length()) {
            char c = s.charAt(rightPointer);
            if (used.containsKey(c)) {
                leftPointer = used.get(c) + 1;
                rightPointer = used.get(c) + 1;
                c = s.charAt(rightPointer);
                used = new HashMap<>();
            }
            used.put(c, rightPointer++);
            longest = Math.max(longest, rightPointer - leftPointer);
        }
        return longest;
    }
}