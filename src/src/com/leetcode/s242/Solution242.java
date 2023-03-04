package src.com.leetcode.s242;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] occurrence = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            occurrence[(charS[i] - 'a')]++;
            occurrence[(charT[i] - 'a')]--;
        }
        for (int j : occurrence) {
            if (j != 0)
                return false;
        }
        return true;
    }
}
