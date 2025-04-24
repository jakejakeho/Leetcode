package src.com.leetcode150.T2_TwoPointers.Q1_ValidPalindrome;
class Solution {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left < s.length() && isInvalidChar(s.charAt(left))) {
                left++;
            }

            while (right >= 0 && isInvalidChar(s.charAt(right))) {
                right--;
            }

            if (left < s.length() && right >= 0 && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(
                s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isInvalidChar(char c) {
        boolean isUpperCase = c >= 'A' && c <= 'Z';
        boolean isLowerCase = c >= 'a' && c <= 'z';
        boolean isNumber = c >= '0' && c <= '9';
        return !isUpperCase && !isLowerCase && !isNumber;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(" "));
        System.out.println(solution.isPalindrome("0P"));
    }
}