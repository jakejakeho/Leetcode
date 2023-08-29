package src.com.leetcode.s5;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        String longestStr = "";

        if (s.length() < 2) {
            return s;
        }

        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int length = right - left + 1;
                if (length > longest) {
                    longest = length;
                    longestStr = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int length = right - left + 1;
                if (length > longest) {
                    longest = length;
                    longestStr = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return longestStr;
    }
}