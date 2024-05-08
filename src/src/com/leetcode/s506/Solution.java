package src.com.leetcode.s506;

import java.util.Arrays;
import java.util.PriorityQueue;


class Solution {

    public static final String GOLD_MEDAL = "Gold Medal";
    public static final String SILVER_MEDAL = "Silver Medal";
    public static final String BRONZE_MEDAL = "Bronze Medal";

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        for (int i = 0; i < score.length; i++) {
            priorityQueue.offer(i);
        }
        String[] result = new String[score.length];
        int rank = 1;
        while (!priorityQueue.isEmpty()) {
            int i = priorityQueue.poll();
            if (rank == 1) {
                result[i] = GOLD_MEDAL;
            } else if (rank == 2) {
                result[i] = SILVER_MEDAL;
            } else if (rank == 3) {
                result[i] = BRONZE_MEDAL;
            } else {
                result[i] = String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}