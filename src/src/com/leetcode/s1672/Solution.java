package src.com.leetcode.s1672;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > max) {
                max = sum;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumWealth(new int[][]{
                {1, 2, 3}, {3, 2, 1}
        }));
        System.out.println(solution.maximumWealth(new int[][]{
                {1, 5}, {7, 5}, {3, 5}
        }));
    }
}