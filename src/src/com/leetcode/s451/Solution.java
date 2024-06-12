package src.com.leetcode.s451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList(map.size());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        list.sort((a, b) -> {
            return b.getValue() - a.getValue();
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}