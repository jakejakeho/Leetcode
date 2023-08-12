package src.com.leetcode.s125;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] cleanString = cleanString(s);
        int left = 0;
        int right = cleanString.length - 1;
        while (left < right) {
            if (cleanString[left] != cleanString[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private char[] cleanString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char lowerCaseChar = Character.toLowerCase(arr[i]);
            if (isValid(lowerCaseChar)) {
                stringBuilder.append(lowerCaseChar);
            }
        }
        return stringBuilder.toString().toCharArray();
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        String input = "race a car";
        Solution solution = new Solution();
        System.out.println("Input: " + input);
        System.out.println("Output: " + solution.isPalindrome(input));
    }
}