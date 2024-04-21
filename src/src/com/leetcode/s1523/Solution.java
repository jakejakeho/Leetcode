package src.com.leetcode.s1523;

class Solution {
    public int countOdds(int low, int high) {
        int length = ((high - low) + 1) / 2;
        if (low % 2 == 1 && high % 2 ==1) {
            length++;
        }
        return length;
    }
}