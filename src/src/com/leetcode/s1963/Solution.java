package src.com.leetcode.s1963;

class Solution {
    public int minSwaps(String s) {
        int minSwap = 0;
        int cur = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '[') {
                cur--;
            } else if (charArr[i] == ']') {
                cur++;
            }
            minSwap = Math.max(minSwap, cur);
        }
        return (minSwap + 1) / 2;
    }
}