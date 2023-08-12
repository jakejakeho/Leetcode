package src.com.leetcode.s125;

import java.util.Objects;

public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleanStr = new StringBuilder();
        for (int i = 0 ; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (isAlphanumeric(c))
                cleanStr.append(c);
        }
        for (int i = 0; i < cleanStr.length() / 2; i++) {
            char leftChar = Character.toLowerCase(cleanStr.charAt(i));
            char rightChar = Character.toLowerCase(cleanStr.charAt(cleanStr.length() - 1 - i));
            if (leftChar != rightChar) {
                return false;
            }
        }
        return true;
    }

    boolean isAlphanumeric (char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        String input = "race a car";
        Solution solution = new Solution();
        System.out.println("Input: " + input);
        System.out.println("Output: " + solution.isPalindrome(input));
    }
}