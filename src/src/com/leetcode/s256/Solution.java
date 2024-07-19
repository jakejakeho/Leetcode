package src.com.leetcode.s256;
import java.util.Arrays;

class Solution {

    int red = 0;

    int green = 2;

    public int minCost(int[][] costs) {
        int[] minCosts = costs[0];
        for (int i = 1; i < costs.length; i++) {
            int[] cost = costs[i];
            int[] newMinCosts = new int[3];
            Arrays.fill(newMinCosts, Integer.MAX_VALUE);
            for (int j = red; j <= green; j++) {
                for (int k = red; k <= green; k++) {
                    if (j != k) {
                        newMinCosts[k] = Math.min(newMinCosts[k], minCosts[j] + cost[k]);
                    }
                }
            }
            minCosts = newMinCosts;
        }
        int min = Integer.MAX_VALUE;
        for (int i = red; i <= green; i++) {
            min = Math.min(min, minCosts[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost(new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19},}));
        System.out.println(solution.minCost(new int[][] {{7, 6, 2,}}));
    }
}