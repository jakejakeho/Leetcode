package src.com.leetcode.s1029;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoCitySchedCost(new int[][] {{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }

    public int twoCitySchedCost(int[][] costs) {
        int[][] costDiff = new int[costs.length][3];
        for (int i = 0; i < costs.length; i++) {
            costDiff[i] = new int[] {i, costs[i][0] - costs[i][1]};
        }
        Arrays.sort(costDiff, (a, b) -> a[1] - b[1]);
        int minCost = 0;
        for (int i = 0; i < costDiff.length; i++) {
            if (i < costDiff.length / 2) {
                minCost += costs[costDiff[i][0]][0];
            } else {
                minCost += costs[costDiff[i][0]][1];
            }
        }

        return minCost;
    }
}