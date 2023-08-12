package src.com.leetcode.s392;

import java.util.Objects;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        while (sPointer < s.length() && tPointer < t.length()) {
            if (Objects.equals(sArr[sPointer], tArr[tPointer])) {
                sPointer++;
                if (sPointer == s.length())
                    return true;
            }
            tPointer++;
        }
        return sPointer == s.length();
    }
}
