package src.com.leetcode.s1356;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortByBits(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8})));
    }

    public int[] sortByBits(int[] arr) {
        int[] results = new int[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int bitCount = Integer.bitCount(num);
            List<Integer> list = map.getOrDefault(bitCount, new ArrayList<>());
            list.add(num);
            map.put(bitCount, list);
        }
        List<Integer> keys = map.keySet()
                                .stream()
                                .sorted()
                                .toList();
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            List<Integer> sorted = map.get(key)
                                      .stream()
                                      .sorted()
                                      .toList();
            for (int num : sorted) {
                results[index++] = num;
            }
        }
        return results;
    }
}