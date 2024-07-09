package src.com.leetcode.s1701;

class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        long currentTime = customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            if (customers[i][0] > currentTime) {
                currentTime = customers[i][0];
            }
            currentTime += customers[i][1];
            totalWaitingTime += (currentTime - customers[i][0]);
        }
        return totalWaitingTime / (customers.length + 0.0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.averageWaitingTime(new int[][]{
                {1, 2},
                {2, 5},
                {4, 3}
        }));
        System.out.println(solution.averageWaitingTime(new int[][]{
                {5, 2},
                {5, 4},
                {10, 3},
                {20, 1},
        }));
    }
}