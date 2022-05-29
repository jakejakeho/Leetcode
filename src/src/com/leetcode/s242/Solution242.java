package src.com.leetcode.s242;

import java.util.HashMap;
import java.util.Map;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> sOccurrence = occurrence(s);
        Map<Character, Integer> tOccurrence = occurrence(t);

        return sOccurrence.equals(tOccurrence);
    }

    private Map<Character, Integer> occurrence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c: s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }
}
