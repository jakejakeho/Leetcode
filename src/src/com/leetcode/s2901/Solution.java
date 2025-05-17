package src.com.leetcode.s2901;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        if (words.length == 1) {
            return List.of(words[0]);
        }
        Map<String, List<String>> cache = new HashMap<>();
        return recursion(-1, 0, words, groups, cache);
    }

    private List<String> recursion(int prev, int current, String[] words, int[] groups,
                                   Map<String, List<String>> cache) {
        String key = prev + "-" + current;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (current >= words.length) {
            return new ArrayList<>();
        }
        // not include this
        List<String> notInclude = recursion(prev, current + 1, words, groups, cache);

        // include this
        List<String> includeThis = new ArrayList<>();
        if (prev == -1 || (groups[current] != groups[prev] && hammingDistance(words[prev], words[current]) == 1)) {
            includeThis = recursion(current, current + 1, words, groups, cache);
            includeThis = new ArrayList<>(includeThis);
            includeThis.addFirst(words[current]);
        }

        List<String> result = (includeThis.size() > notInclude.size()) ? includeThis : notInclude;

        cache.put(key, result);
        return result;
    }

    private int hammingDistance(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return 0;
        }
        int hammingDistance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
            solution.getWordsInLongestSubsequence(new String[] {"bab", "dab", "cab"}, new int[] {1, 2, 2}));
        System.out.println(
            solution.getWordsInLongestSubsequence(new String[] {"a", "b", "c", "d"}, new int[] {1, 2, 3, 4}));
    }
}