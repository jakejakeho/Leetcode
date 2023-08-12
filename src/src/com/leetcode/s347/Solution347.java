package src.com.leetcode.s347;

import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry entry : map.entrySet()) {
            queue.offer(entry);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            result[i] = entry.getKey();
        }
        return result;
    }
}
