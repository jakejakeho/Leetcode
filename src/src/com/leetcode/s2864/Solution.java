package src.com.leetcode.s2864;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder result = new StringBuilder(s.length());
        int numOfOne = 0;
        int numOfZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                numOfZero++;
            } else {
                numOfOne++;
            }
        }
        result.append("1".repeat(Math.max(0, numOfOne - 1)));
        result.append("0".repeat(Math.max(0, numOfZero)));
        result.append('1');
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumOddBinaryNumber("010"));
        System.out.println(solution.maximumOddBinaryNumber("1001"));
    }
}