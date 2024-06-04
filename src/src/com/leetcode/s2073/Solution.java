package src.com.leetcode.s2073;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ticketIndex = 0;
        int timeRequired = 0;
        while (tickets[k] > 0) {
            if (tickets[ticketIndex] > 0) {
                tickets[ticketIndex] -= 1;
                timeRequired++;
            }
            ticketIndex = (ticketIndex + 1) % tickets.length;
        }
        return timeRequired;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(solution.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(solution.timeRequiredToBuy(new int[]{84, 49, 5, 24, 70, 77, 87, 8}, 3));
    }
}