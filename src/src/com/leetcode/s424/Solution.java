package src.com.leetcode.s424;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AABABBA";
        int k = 1;
        System.out.println("Input: s = " + s + ", k = " + k);
        System.out.println("Output: " + solution.characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        int longest = 0;
        int i = 0;
        int[] arr = new int[26];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }
}