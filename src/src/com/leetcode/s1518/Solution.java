package src.com.leetcode.s1518;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int numWaterBottles = 0;
        int emptyBottles = 0;
        do {
            numWaterBottles += numBottles;
            emptyBottles += numBottles;
            numBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
            if (numBottles + emptyBottles < numExchange) {
                numWaterBottles += numBottles;
                numBottles = 0;
            }
        } while (numBottles > 0);
        return numWaterBottles;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWaterBottles(9, 3));
        System.out.println(solution.numWaterBottles(15, 4));
    }
}