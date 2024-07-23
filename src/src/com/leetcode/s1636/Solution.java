package src.com.leetcode.s1636;

import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> {
            if (Objects.equals(a.getValue(), b.getValue())) {
                return b.getKey() - a.getKey();
            }
            return a.getValue() - b.getValue();
        });
        int index = 0;
        for (var entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                nums[index++] = entry.getKey();
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{2, 3, 1, 3, 2})));
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }
}