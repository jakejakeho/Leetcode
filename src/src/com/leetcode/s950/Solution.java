package src.com.leetcode.s950;

import java.util.*;

class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }

        int[] order = new int[deck.length];
        int index = 0;
        while (!queue.isEmpty()) {
            order[index++] = queue.poll();
            if (!queue.isEmpty())
                queue.offer(queue.poll());
        }

        Arrays.sort(deck);
        int[] result = new int[deck.length];
        for (int i = 0; i < order.length; i++) {
            result[order[i]] = deck[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }
}
