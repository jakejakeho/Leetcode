package src.com.leetcode.s438;

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        int[] pMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char pChar = p.charAt(i);
            pMap[pChar - 'a']++;
        }
        int[] sMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char sChar = s.charAt(i);
            sMap[sChar - 'a']++;
        }
        List<Integer> startIndices = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            boolean isSame = true;
            for (int j = 0; j < 26; j++) {
                if (sMap[j] != pMap[j]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                startIndices.add(i);
            }


            // remove current index
            char currentChar = s.charAt(i);
            sMap[currentChar - 'a']--;

            // add next char
            if (i + p.length() < s.length()) {
                char nextChar = s.charAt(i + p.length());
                sMap[nextChar - 'a']++;
            }
        }
        return startIndices;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }
}