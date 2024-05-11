package src.com.leetcode.s857;

import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double minCost = Double.MAX_VALUE;

        double[][] wageQuality = new double[wage.length][2];
        for (int i = 0; i < quality.length; i++) {
            wageQuality[i] = new double[]{(double) wage[i] / quality[i], i};
        }
        Arrays.sort(wageQuality, Comparator.comparingDouble(a -> a[0]));


        int totalQuality = 0;
        PriorityQueue<Integer> highestQuality = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < quality.length; i++) {
            highestQuality.offer(quality[(int) wageQuality[i][1]]);
            totalQuality += quality[(int) wageQuality[i][1]];
            if (highestQuality.size() > k) {
                totalQuality -= highestQuality.poll();
            }

            if (highestQuality.size() == k) {
                double cost = totalQuality * wageQuality[i][0];
                if (cost < minCost) {
                    minCost = cost;
                }
            }
        }
        return minCost;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
        System.out.println(solution.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }
}