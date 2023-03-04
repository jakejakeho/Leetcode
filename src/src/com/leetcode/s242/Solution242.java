package src.com.leetcode.s242;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] occurrenceS = new int[26];
        int[] occurrenceT = new int[26];
        for (char c: s.toCharArray()) {
            occurrenceS[(c - 'a')]++;
        }
        for (char c: t.toCharArray()) {
            occurrenceT[(c - 'a')]++;
        }

        for (int i = 0; i < occurrenceS.length;i++) {
            if (occurrenceS[i] != occurrenceT[i])
                return false;
        }
        return true;
    }
}
