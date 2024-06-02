package src.com.leetcode.s2264;

class Solution {
    public String largestGoodInteger(String num) {
        int goodInteger = -1;
        int lastDigit = -1;
        int sameCount = 0;
        for (int i = 0; i < num.length(); i++) {
            int currentDigit = num.charAt(i) - '0';
            if (currentDigit == lastDigit) {
                sameCount++;
                if (sameCount == 3) {
                    goodInteger = Math.max(currentDigit, goodInteger);
                }
            } else {
                lastDigit = currentDigit;
                sameCount = 1;
            }
        }
        if (goodInteger == -1)
            return "";
        else
            return String.valueOf(goodInteger).repeat(3);
    }
}