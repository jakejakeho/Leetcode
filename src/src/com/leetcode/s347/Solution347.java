package src.com.leetcode.s347;

import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }

        ArrayList<Integer>[] frequencies = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            if (frequencies[frequency] == null) {
                frequencies[frequency] = new ArrayList<>();
            }
            frequencies[frequency].add(key);
        }

        int index = 0;
        int[] result = new int[k];
        for (int frequency = nums.length; frequency > 0; frequency--) {
            ArrayList<Integer> keys = frequencies[frequency];
            if (keys != null) {
                for (Integer key : keys) {
                    result[index++] = key;
                    if (index == k)
                        return result;
                }
            }
        }
        return result;
    }
}
