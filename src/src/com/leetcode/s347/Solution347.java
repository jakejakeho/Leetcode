package src.com.leetcode.s347;

import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        // number, count
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        int[][] results = new int[hashMap.values().size()][2];
        int entryIndex = 0;
        for (HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            results[entryIndex][0] = entry.getKey();
            results[entryIndex][1] = entry.getValue();
            entryIndex++;
        }

        Arrays.sort(results, Comparator.comparingInt(o -> o[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = results[results.length - i - 1][0];
        }
        return result;
    }
}
