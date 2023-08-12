package src.com.leetcode.s290;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] patternArr = pattern.toCharArray();
        HashMap<String, Character> hashMap = new HashMap<>();
        if (patternArr.length != words.length)
            return false;
        for (int i = 0; i < words.length; i++) {
            char patternChar = patternArr[i];
            String word = words[i];
            if (!hashMap.containsKey(word))
                hashMap.put(word, patternChar);
            else {
                boolean equal = hashMap.get(word).equals(patternChar);
                if (!equal)
                    return false;
            }
        }

        HashMap<Character, String> hashMap2 = new HashMap<>();
        for (int i = 0; i < patternArr.length; i++) {
            char patternChar = patternArr[i];
            String word = words[i];
            if (!hashMap2.containsKey(patternChar))
                hashMap2.put(patternChar, word);
            else {
                boolean equal = hashMap2.get(patternChar).equals(word);
                if (!equal)
                    return false;
            }
        }
        return true;
    }
}
