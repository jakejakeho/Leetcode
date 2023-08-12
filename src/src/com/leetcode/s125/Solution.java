package src.com.leetcode.s125;

import java.util.Objects;

public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            Character leftChar = Character.toLowerCase(s.charAt(left));
            Character rightChar = Character.toLowerCase(s.charAt(right));
            if (!isAlphanumeric(leftChar)) {
                left++;
                continue;
            }
            if (!isAlphanumeric(rightChar)) {
                right--;
                continue;
            }
            if (!Objects.equals(leftChar, rightChar))
                return false;
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphanumeric(Character testChar) {
        return (testChar >= 'a' && testChar <= 'z') || (testChar >= '0' && testChar <= '9');
    }
}