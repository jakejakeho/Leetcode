package src.com.leetcode.s371;
class Solution {

    public int getSum(int a, int b) {
        int result = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int bit1 = a >> i & 1;
            int bit2 = b >> i & 1;
            int xor = bit1 ^ bit2 ^ carry;
            carry = (bit1 & bit2) | (bit2 & carry) | (bit1 & carry);
            if (xor == 1)
                result |= 1 << i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(1, 1));
    }
}