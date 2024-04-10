package src.com.leetcode.s2073;

class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0;
        int target = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (i > k && tickets[i] >= target) {total += Math.min(target - 1, tickets[i]);} else {
                total += Math.min(target, tickets[i]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected = 6 Actual = " + solution.timeRequiredToBuy(new int[] {2, 3, 2}, 2));
        System.out.println("Expected = 8 Actual = " + solution.timeRequiredToBuy(new int[] {5, 1, 1, 1}, 0));
        System.out.println(
            "Expected = 154 Actual = " + solution.timeRequiredToBuy(new int[] {84, 49, 5, 24, 70, 77, 87, 8}, 3));
        System.out.println("Expected = 1457 Actual = " + solution.timeRequiredToBuy(
            new int[] {15, 66, 3, 47, 71, 27, 54, 43, 97, 34, 94, 33, 54, 26, 15, 52, 20, 71, 88, 42, 50, 6, 66, 88, 36,
                99, 27, 82, 7, 72}, 18));
    }
}