package src.com.leetcode.s49;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] occurrence = new char[26];
            for (char c : s.toCharArray()) {
                occurrence[c - 'a']++;
            }
            String str = new String(occurrence);
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(s);
        }
        return map.values().stream().toList();
    }
}
