package src.com.leetcode.s49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] charArray = new char[26];
            for (char c : s.toCharArray()) {
                charArray[c - 'a']++;
            }
            String key = Arrays.toString(charArray);
            List<String> list = hashMap.getOrDefault(key, new ArrayList<>());
            list.add(s);
            hashMap.put(key, list);
        }
        return hashMap.values().stream().toList();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = { "eat","tea","tan","ate","nat","bat" };

        System.out.println("Input: "+ Arrays.toString(strs) + "\nOutput: " + solution.groupAnagrams(strs));

    }
}
