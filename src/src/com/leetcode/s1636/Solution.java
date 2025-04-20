package src.com.leetcode.s1636;

import java.util.*;

class Solution {

    record Pair(int key, int value) {
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Pair> sorted = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sorted.add(new Pair(entry.getValue(), entry.getKey()));
        }
        sorted.sort((a, b) -> {
            int aFreq = a.key;
            int bFreq = b.key;
            if (aFreq == bFreq) {
                return b.value - a.value;
            }
            return a.key - b.key;
        });

        int index = 0;
        for (int i = 0; i < sorted.size(); i++) {
            int freq = sorted.get(i).key;
            int value = sorted.get(i).value;
            for (int j = 0; j < freq; j++) {
                nums[index++] = value;
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