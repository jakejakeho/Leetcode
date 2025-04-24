package src.com.leetcode150.ArraysHashing.Q5TopKFrequentElements;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Map<Integer, List<Integer>> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            treeMap.computeIfAbsent(entry.getValue(), key -> new ArrayList<>());
            treeMap.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            list.addAll(entry.getValue());
            if (list.size() == k) {
                break;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[] {1}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[] {1, 2}, 2)));
    }
}