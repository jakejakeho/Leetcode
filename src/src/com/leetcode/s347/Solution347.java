package src.com.leetcode.s347;

import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurrence = new HashMap<>();
        for (Integer num : nums) {
            occurrence.put(num, occurrence.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> entry: occurrence.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> results = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            results.add(minHeap.poll().getKey());
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
