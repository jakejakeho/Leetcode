package src.com.leetcode.s2014;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Character> candidate = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                candidate.add((char)('a' + i));
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (Character c : candidate) {
            queue.offer(String.valueOf(c));
        }

        String ans = "";
        while (!queue.isEmpty()) {
            String attempt = queue.poll();
            if (attempt.length() > ans.length()) {
                ans = attempt;
            }
            for (Character c : candidate) {
                String next = attempt + c;
                if (isValid(s, next, k)) {
                    queue.offer(next);
                }
            }
        }
        return ans;
    }

    private boolean isValid(String s, String next, int k) {
        int pos = 0;
        int match = 0;
        for (char c : s.toCharArray()) {
            if (c == next.charAt(pos)) {
                pos++;
                if (pos == next.length()) {
                    match++;
                    pos = 0;
                    if (match == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubsequenceRepeatedK("letsleetcode", 2));
        System.out.println(solution.longestSubsequenceRepeatedK("bb", 2));
        System.out.println(solution.longestSubsequenceRepeatedK("ab", 2));
    }
}