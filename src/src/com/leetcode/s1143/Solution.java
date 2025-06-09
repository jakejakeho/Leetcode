package src.com.leetcode.s1143;

import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return recursion(text1, text2, cache, 0, 0);
    }

    private int recursion(String text1, String text2, int[][] cache, int i, int j) {
        if (i >= text1.length()) {
            return 0;
        }
        if (j >= text2.length()) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + recursion(text1, text2, cache, i + 1, j + 1);
        }
        int longest = Math.max(recursion(text1, text2, cache, i + 1, j), recursion(text1, text2, cache, i, j + 1));
        cache[i][j] = longest;
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
        System.out.println(solution.longestCommonSubsequence("abc", "abc"));
        System.out.println(solution.longestCommonSubsequence("abc", "def"));
    }
}