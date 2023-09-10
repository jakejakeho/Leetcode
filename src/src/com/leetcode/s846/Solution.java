package src.com.leetcode.s846;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(solution.isNStraightHand(new int[]{8, 10, 12}, 3));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);
        for (int card : hand) {
            if (countMap.get(card) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (countMap.getOrDefault(currentCard, 0) == 0) {
                    return false;
                }
                countMap.put(currentCard, countMap.get(currentCard) - 1);
            }
        }
        return true;
    }
}