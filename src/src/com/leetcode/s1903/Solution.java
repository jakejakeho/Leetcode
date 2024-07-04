package src.com.leetcode.s1903;

class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestOddNumber("52"));
        System.out.println(solution.largestOddNumber("4206"));
        System.out.println(solution.largestOddNumber("35427"));
    }
}