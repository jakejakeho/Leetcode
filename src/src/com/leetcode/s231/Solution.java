package src.com.leetcode.s231;

class Solution {
    public boolean isPowerOfTwo(int n) {
        int bitCount = Integer.bitCount(n);
        return (n > 0 && bitCount == 1);
    }
}