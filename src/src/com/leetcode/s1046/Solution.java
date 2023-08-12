package src.com.leetcode.s1046;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }

        while (priorityQueue.size() > 1) {
            int y = priorityQueue.poll();
            int x = priorityQueue.poll();
            if (x != y) {
                y = y - x;
                priorityQueue.offer(y);
            }
        }
        if (priorityQueue.size() == 1) {
            return priorityQueue.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        int result = new Solution().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println(result);
    }
}
