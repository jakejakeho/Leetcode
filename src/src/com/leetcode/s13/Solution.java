package src.com.leetcode.s13;
class Solution {

    public int romanToInt(String s) {
        int num = 0;
        int pointer = 0;
        while (pointer < s.length()) {
            if (s.charAt(pointer) == 'C' && pointer + 1 < s.length() && s.charAt(pointer + 1) == 'D') {
                num += 400;
                pointer++;
            } else if (s.charAt(pointer) == 'C' && pointer + 1 < s.length() && s.charAt(pointer + 1) == 'M') {
                num += 900;
                pointer++;
            } else if (s.charAt(pointer) == 'D') {
                num += 500;
            } else if (s.charAt(pointer) == 'M') {
                num += 1000;
            } else if (s.charAt(pointer) == 'X' && pointer + 1 < s.length() && s.charAt(pointer + 1) == 'L') {
                num += 40;
                pointer++;
            } else if (s.charAt(pointer) == 'X' && pointer + 1 < s.length() && s.charAt(pointer + 1) == 'C') {
                num += 90;
                pointer++;
            } else if (s.charAt(pointer) == 'L') {
                num += 50;
            } else if (s.charAt(pointer) == 'C') {
                num += 100;
            } else if (s.charAt(pointer) == 'I' && pointer + 1 < s.length() && s.charAt(pointer + 1) == 'V') {
                num += 4;
                pointer++;
            } else if (s.charAt(pointer) == 'I' && pointer + 1 < s.length() && s.charAt(pointer + 1) == 'X') {
                num += 9;
                pointer++;
            } else if (s.charAt(pointer) == 'V') {
                num += 5;
            } else if (s.charAt(pointer) == 'X') {
                num += 10;
            } else if (s.charAt(pointer) == 'I') {
                num += 1;
            }
            pointer++;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("DCXXI")); // 621
    }
}