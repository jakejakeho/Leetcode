package src.com.leetcode.s2706;

import java.util.PriorityQueue;

class Solution {
    public int buyChoco(int[] prices, int money) {
        PriorityQueue<Integer> priceQueue = new PriorityQueue<>();
        for (int price : prices) {
            priceQueue.offer(price);
        }
        while (priceQueue.size() >= 2) {
            Integer price1 = priceQueue.poll();
            Integer price2 = priceQueue.poll();
            int sum = price1 + price2;
            if (money >= sum) {
                money -= sum;
                break;
            } else {
                break;
            }
        }
        return money;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buyChoco(new int[]{1, 2, 2}, 3));
        System.out.println(solution.buyChoco(new int[]{3, 2, 3}, 3));
    }
}