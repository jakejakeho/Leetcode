package src.com.leetcode.s1137;

class Solution {
    public int tribonacci(int n) {
        int T0 = 0;
        int T1 = 1;
        int T2 = 1;
        int T3 = -1;
        if (n == 0) {
            return T0;
        } else if (n == 1) {
            return T1;
        } else if (n == 2) {
            return T2;
        }
        for (int i = 3; i <= n; i++) {
            T3 = T0 + T1 + T2;
            T0 = T1;
            T1 = T2;
            T2 = T3;
        }
        return T3;
    }
}