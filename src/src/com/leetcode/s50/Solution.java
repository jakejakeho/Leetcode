package src.com.leetcode.s50;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2., -2147483648));
    }

    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = 0; i < Math.abs(n); i++) {
            result *= x;
        }
        return n < 0 ? 1 / result : result;
    }
}