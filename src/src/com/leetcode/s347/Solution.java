package src.com.leetcode.s347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> countMap = new HashMap<>();
       for (int num : nums) {
           countMap.putIfAbsent(num, 0);
           countMap.put(num, countMap.get(num) + 1);
       }
       PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Map.Entry.comparingByValue());
       for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
           priorityQueue.offer(entry);
           if (priorityQueue.size() > k) {
               priorityQueue.poll();
           }
       }
       int[] result = new int[k];
       for (int i = 0; i < k; i++) {
           result[i] = priorityQueue.poll().getKey();
       }
       return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        int k = 2;

        System.out.println("Input: nums = " + Arrays.toString(nums) + " k = " + k);
        System.out.println("Output: " + Arrays.toString(solution.topKFrequent(nums, k)));
    }
}
