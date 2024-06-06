package src.com.leetcode.s846;

import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            countMap.put(hand[i], countMap.getOrDefault(hand[i], 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer key : countMap.keySet()) {
            priorityQueue.offer(key);
        }
        while (!priorityQueue.isEmpty()) {
            Integer smallest = priorityQueue.poll();
            if (countMap.get(smallest) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int key = smallest + i;
                int count = countMap.getOrDefault(key, 0);
                if (count == 0) {
                    return false;
                }
                count--;
                countMap.put(key, count);
            }
            if (countMap.get(smallest) > 0) {
                priorityQueue.offer(smallest);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(solution.isNStraightHand(new int[]{53, 78, 62, 108, 83, 56, 66, 110, 49, 104, 117, 123, 86, 131, 94, 107, 84, 103, 42, 127, 100, 50, 55, 97, 81, 93, 71, 45, 63, 39, 91, 87, 129, 126, 84, 125, 73, 95, 116, 47, 106, 52, 121, 54, 38, 68, 69, 76, 89, 90, 57, 67, 86, 114, 64, 87, 79, 92, 115, 60, 51, 105, 132, 101, 59, 130, 44, 85, 80, 82, 48, 65, 128, 102, 74, 61, 40, 46, 98, 111, 109, 119, 72, 43, 112, 120, 58, 113, 77, 88, 41, 118, 75, 85, 124, 122, 96, 83, 99, 70}, 50));
    }
}