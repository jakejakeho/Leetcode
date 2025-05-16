package src.com.leetcode.s2901;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        int lastGroup = groups[0];
        String lastStr = words[0];
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != lastGroup
                    && lastStr.length() == words[i].length()
                    && hammingDistance(lastStr, words[i]) == 1) {
                result.add(words[i]);
                lastGroup = groups[i];
                lastStr = words[i];
            }
        }
        return result;
    }

    private int hammingDistance(String s1, String s2) {
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
        System.out.println(solution.getWordsInLongestSubsequence(new String[]{"bab", "dab", "cab"}, new int[]{1, 2, 2}));
        System.out.println(solution.getWordsInLongestSubsequence(new String[]{"a", "b", "c", "d"}, new int[]{1, 2, 3, 4}));
    }
}