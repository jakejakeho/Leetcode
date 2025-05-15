package src.com.leetcode.s2900;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int lastGroup = groups[0];
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (lastGroup != groups[i]) {
                lastGroup = groups[i];
                result.add(words[i]);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLongestSubsequence(new String[]{"e", "a", "b"}, new int[]{0, 0, 1}));
        System.out.println(solution.getLongestSubsequence(new String[]{"a", "b", "c", "d"}, new int[]{1, 0, 0, 1}));
    }
}