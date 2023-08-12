package src.com.leetcode.s49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] count = new char[26];
            for (Character c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = new String(count);
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("Input: " + Arrays.toString(strs) + "\nOutput: " + solution.groupAnagrams(strs));

    }
}
