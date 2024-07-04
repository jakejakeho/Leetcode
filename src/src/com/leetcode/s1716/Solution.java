package src.com.leetcode.s1716;
class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int firstWeekTotal = 0;
        for (int i = 1; i <= 7; i++) {
            firstWeekTotal += i;
        }
        int numOfWeeks = (int)Math.floor(n / 7.0);
        int remainder = n % 7;
        for (int i = 0; i < numOfWeeks; i++) {
            total += firstWeekTotal + (i * 7);
        }
        for (int i = 0; i < remainder; i++) {
            total += (numOfWeeks + 1 + i);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalMoney(4));
        System.out.println(solution.totalMoney(10));
        System.out.println(solution.totalMoney(20));
    }
}