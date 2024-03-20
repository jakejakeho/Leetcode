package src.com.leetcode.s621;


import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> nextUseMap = new HashMap<>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
            nextUseMap.putIfAbsent(task, Integer.MIN_VALUE);
        }
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a.getValue()));
        priorityQueue.addAll(nextUseMap.entrySet());
        int result = 0;
        while (!countMap.isEmpty()) {
            Map.Entry<Character, Integer> nextUse = priorityQueue.peek();
            System.out.println(nextUse);
            if (result >= nextUse.getValue()) {
                nextUse.setValue(result + n + 1);
                countMap.put(nextUse.getKey(), countMap.get(nextUse.getKey()) - 1);
                if (countMap.get(nextUse.getKey()) == 0) {
                    countMap.remove(nextUse.getKey());
                    priorityQueue.remove(nextUse);
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println("1======");
//        System.out.println(solution.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 2));
//        System.out.println("2======");
//        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
//        System.out.println("3======");
//        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
//        System.out.println("4======");
    }
}