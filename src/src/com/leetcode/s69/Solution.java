package src.com.leetcode.s69;

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        long left = 0;
        long right = x;
        long mid = (left + right) / 2;
        while (left <= right) {
            long square = mid * mid;
            if (square == x) {
                break;
            } else if (square > x) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }

        return (int)mid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(8));
    }
}