package src.com.leetcode.s3175;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.TreeMap;

class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        if (k >= skills.length - 1) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < skills.length; i++) {
                treeMap.put(skills[i], i);
            }
            return treeMap.firstEntry().getValue();
        }
        int[] score = new int[skills.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>(skills.length);
        for (int i = 0; i < skills.length; i++) {
            queue.offer(i);
        }
        while (true) {
            int player1 = queue.pollFirst();
            int player2 = queue.pollFirst();
            int winner = 0;
            int loser = 0;
            if (skills[player1] > skills[player2]) {
                // player1 win
                winner = player1;
                loser = player2;
            } else if (skills[player1] < skills[player2]) {
                // player2 win
                winner = player2;
                loser = player1;
            }
            queue.offerFirst(winner);
            queue.offerLast(loser);
            score[winner]++;
            if (score[winner] == k) {
                return winner;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWinningPlayer(new int[]{4, 2, 6, 3, 9}, 2));
        System.out.println(solution.findWinningPlayer(new int[]{2, 5, 4}, 3));
        System.out.println(solution.findWinningPlayer(new int[]{16, 4, 7, 17}, 3));
    }
}