package src.com.leetcode.s1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    cache[i][j] = 1 + cache[i + 1][j + 1];
                } else {
                    cache[i][j] = Math.max(cache[i + 1][j], cache[i][j + 1]);
                }
            }
        }
        return cache[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
        System.out.println(solution.longestCommonSubsequence("abc", "abc"));
        System.out.println(solution.longestCommonSubsequence("abc", "def"));
    }
}