package src.com.leetcode.s190;
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(43261596));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        System.out.println(n);
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int lastBit = n >> i & 1;
            if (lastBit == 1) {
                result |= 1 << (32 - 1 - i);
            }
        }
        return result;
    }
}