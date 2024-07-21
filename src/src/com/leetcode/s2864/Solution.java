package src.com.leetcode.s2864;

import java.util.Map;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        StringBuilder result = new StringBuilder();
        while (oneCount > 1) {
            result.append('1');
            oneCount--;
        }
        while (zeroCount > 0) {
            result.append('0');
            zeroCount--;

        }
        while (oneCount > 0) {
            result.append('1');
            oneCount--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumOddBinaryNumber("010"));
        System.out.println(solution.maximumOddBinaryNumber("0101"));
    }
}