package src.com.leetcode.s983;
import java.util.Arrays;

class Solution {

    /**
     * 983. Minimum Cost For Tickets Medium Topics Companies You have planned some train traveling one year in advance.
     * The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1
     * to 365.
     * <p>
     * Train tickets are sold in three different ways:
     * <p>
     * a 1-day pass is sold for costs[0] dollars, a 7-day pass is sold for costs[1] dollars, and a 30-day pass is sold
     * for costs[2] dollars. The passes allow that many days of consecutive travel.
     * <p>
     * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8. Return the
     * minimum number of dollars you need to travel every day in the given list of days.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: days = [1,4,6,7,8,20], costs = [2,7,15] Output: 11 Explanation: For example, here is one way to buy passes
     * that lets you travel your travel plan: On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
     * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9. On day 20, you bought a
     * 1-day pass for costs[0] = $2, which covered day 20. In total, you spent $11 and covered all the days of your
     * travel. Example 2:
     * <p>
     * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15] Output: 17 Explanation: For example, here is one way
     * to buy passes that lets you travel your travel plan: On day 1, you bought a 30-day pass for costs[2] = $15 which
     * covered days 1, 2, ..., 30. On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31. In total,
     * you spent $17 and covered all the days of your travel.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= days.length <= 365 1 <= days[i] <= 365 days is in strictly increasing order. costs.length == 3 1 <= costs[i]
     * <= 1000
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] minCost = new int[days.length];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        return dfs(days, costs, minCost, 0);
    }

    private int dfs(int[] days, int[] costs, int[] minCost, int i) {
        if (i >= days.length) {
            return 0;
        }
        if (minCost[i] != Integer.MAX_VALUE) {
            return minCost[i];
        }
        int currentMinCost = Integer.MAX_VALUE;
        // 1 day
        currentMinCost = Math.min(currentMinCost, costs[0] + dfs(days, costs, minCost, i + 1));
        // 7 days
        int after7DaysRange = i + 1;
        for (int j = i ; j < days.length; j++) {
            if (days[j] < days[i] + 7) {
                after7DaysRange = j + 1;
            } else {
                break;
            }
        }
        currentMinCost = Math.min(currentMinCost, costs[1] + dfs(days, costs, minCost, after7DaysRange));
        // 30 days
        int after30DaysRange = i + 1;
        for (int j = i ; j < days.length; j++) {
            if (days[j] < days[i] + 30) {
                after30DaysRange = j + 1;
            } else {
                break;
            }
        }
        currentMinCost = Math.min(currentMinCost, costs[2] + dfs(days, costs, minCost, after30DaysRange));

        minCost[i] = currentMinCost;
        return currentMinCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mincostTickets(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}));
        System.out.println(solution.mincostTickets(new int[] {1,2,3,4,5,6,7,8,9,10,30,31}, new int[] {2, 7, 15}));
    }
}