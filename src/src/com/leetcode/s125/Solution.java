package src.com.leetcode.s125;

public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ;i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i)) && !Character.isSpaceChar(s.charAt(i)))
                stringBuilder.append(s.charAt(i));
        }
        stringBuilder = new StringBuilder(stringBuilder.toString().toLowerCase());
        String filtered = stringBuilder.toString();
        return filtered.equals(new StringBuilder(filtered).reverse().toString());
    }
}