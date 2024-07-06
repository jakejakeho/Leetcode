package src.com.leetcode.s342;

class Solution {
    public boolean isPowerOfFour(int n) {
        double power = Math.log(n) / Math.log(4);
        return (power - Math.floor(power)) == 0.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(16));
        System.out.println(solution.isPowerOfFour(5));
        System.out.println(solution.isPowerOfFour(1));
    }
}