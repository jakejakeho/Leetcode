package src.com.leetcode.s9;

class Solution {
    // Handle negative numbers and numbers ending in 0 (except 0 itself)
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        // If the length of the original number is odd, we can remove the middle digit
        // from the reversed number and compare the remaining digits
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));   // Output: true
        System.out.println(isPalindrome(-121));  // Output: false
        System.out.println(isPalindrome(10));    // Output: false
    }
}