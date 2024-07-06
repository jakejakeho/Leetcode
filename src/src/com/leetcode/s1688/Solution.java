package src.com.leetcode.s1688;

class Solution {
    public int numberOfMatches(int n) {
        int numOfMatches = 0;
        while (n >= 2) {
            if (n % 2 == 1) {
                n--;
                numOfMatches++;
            }
            numOfMatches += n / 2;
            n /= 2;
        }
        return numOfMatches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfMatches(7));
        System.out.println(solution.numberOfMatches(14));
    }
}