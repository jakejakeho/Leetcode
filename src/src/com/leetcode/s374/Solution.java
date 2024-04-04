package src.com.leetcode.s374;

/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.guessNumber(2126753390));
    }

    public int guessNumber(int n) {
        long left = 1;
        long right = n;
        long mid = (left + right) / 2;
        while (left <= right) {
            if (guess((int)mid) == 0) {
                return (int)mid;
            } else if (guess((int)mid) == -1) {
                right = mid - 1;
            } else if (guess((int)mid) == 1) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    int guess(int num) {
        return Integer.compare(1702766719, num);
    }
}