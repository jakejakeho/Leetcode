package src.com.leetcode.s2418;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        int i = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            names[i++] = entry.getValue();
        }
        return names;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortPeople(new String[]{"Mary", "John", "Emma"},
                new int[]{180, 165, 170})));
        System.out.println(Arrays.toString(solution.sortPeople(new String[]{"Alice", "Bob", "Bob"},
                new int[]{155, 185, 150})));
    }
}