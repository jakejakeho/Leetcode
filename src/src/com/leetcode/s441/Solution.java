package src.com.leetcode.s441;

class Solution {
    public int arrangeCoins(int n) {
        if (n == 0) return 0;
        long left = 1;
        long right = n;
        long row = (left + right) / 2;
        while (left <= right) {
            long coins = row * (row + 1) / 2;
            if (n == coins) {
                return (int)row;
            } else if (n < coins) {
                right = row - 1;
            } else {
                left = row + 1;
            }
            row = (left + right) / 2;
        }
        return (int)row;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(8));}
}