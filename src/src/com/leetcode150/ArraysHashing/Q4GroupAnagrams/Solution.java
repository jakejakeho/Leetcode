package src.com.leetcode150.ArraysHashing.Q4GroupAnagrams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (char c : str.toCharArray()) {
                arr[c - 'a']++;
            }
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(str);
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}