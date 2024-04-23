package src.com.leetcode.s752;

import java.util.*;

class Solution {
    Map<Character, Character> nextSlot = Map.of(
            '0', '1',
            '1', '2',
            '2', '3',
            '3', '4',
            '4', '5',
            '5', '6',
            '6', '7',
            '7', '8',
            '8', '9',
            '9', '0'
    );
    // Map the previous slot digit for each current slot digit.
    Map<Character, Character> prevSlot = Map.of(
            '0', '9',
            '1', '0',
            '2', '1',
            '3', '2',
            '4', '3',
            '5', '4',
            '6', '5',
            '7', '6',
            '8', '7',
            '9', '8'
    );

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int turn = 0;

        if (visited.contains("0000")) {
            return -1;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (Objects.equals(current, target)) {
                    return turn;
                }
                visited.add(current);
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder(current);
                    sb.setCharAt(j, nextSlot.get(current.charAt(j)));
                    String plus = sb.toString();
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    sb.setCharAt(j, prevSlot.get(current.charAt(j)));
                    String minus = sb.toString();
                    if (!visited.contains(minus)) {
                        queue.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            turn++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }
}