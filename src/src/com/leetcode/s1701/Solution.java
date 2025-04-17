package src.com.leetcode.s1701;
class Solution {

    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0.0;
        int chefTime = 0;
        for (int i = 0; i < customers.length; i++) {
            int startTime;
            if (customers[i][0] >= chefTime) {
                startTime = customers[i][0];
            } else {
                startTime = chefTime;
            }
            chefTime = startTime + customers[i][1];
            int waitingTime = chefTime - customers[i][0];
            totalWaitingTime += waitingTime;
        }
        return totalWaitingTime / customers.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.averageWaitingTime(new int[][] {{1, 2}, {2, 5}, {4, 3}}));
        System.out.println(solution.averageWaitingTime(new int[][] {{5, 2}, {5, 4}, {10, 3}, {20, 1}}));
    }
}