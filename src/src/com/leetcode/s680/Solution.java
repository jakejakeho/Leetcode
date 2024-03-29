package src.com.leetcode.s680;

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean skipOnce = true;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                skipOnce = false;
                break;
            }
            left++;
            right--;
        }

        if (!skipOnce) {
            // delete left
            int tmpLeft = left + 1;
            int tmpRight = right;
            boolean isOk = true;
            while (tmpLeft <= tmpRight) {
                if (s.charAt(tmpLeft) != s.charAt(tmpRight)) {
                    isOk = false;
                }
                tmpLeft++;
                tmpRight--;
            }

            if (!isOk) {
                // delete right
                right--;
                while (left <= right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        return false;
                    }
                    left++;
                    right--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("abc"));
    }
}