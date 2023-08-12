package src.com.leetcode.s58;

public class Solution {
    public int lengthOfLastWord(String s) {
        char[] charArr = s.toCharArray();
        boolean meetFirstChar = false;
        int count = 0;
        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] != ' ') {
                meetFirstChar = true;
            } else {
                if (meetFirstChar) {
                    return count;
                }
            }
            if (meetFirstChar) {
                count++;
            }
        }
        return count;
    }
}
