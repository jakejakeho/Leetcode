package src.com.leetcode.s1002;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] exist = null;
        for (String word : words) {
            int[] current = new int[26];
            for (char c : word.toCharArray()) {
                current[c - 'a']++;
            }
            if (exist == null) {
                exist = current;
            } else {
                for (int j = 0; j < 26; j++) {
                    exist[j] = Math.min(exist[j], current[j]);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            while (exist[i] > 0) {
                result.add(String.valueOf((char) ('a' + i)));
                exist[i]--;
            }
        }
        return result;
    }
}