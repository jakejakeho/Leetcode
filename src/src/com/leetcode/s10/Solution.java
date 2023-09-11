package src.com.leetcode.s10;
import java.util.Arrays;

class Solution {

    public boolean isMatch(String s, String p) {
        int[][] cache = new int[s.length()][p.length()];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return recursive(s, p, cache, 0, 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected = false result = " + solution.isMatch("bbab", "b*a*"));
    }

    public boolean recursive(String s, String p, int[][] cache, int sPointer, int pPointer) {
        if (sPointer >= s.length() && pPointer >= p.length()) {
            return true;
        }
        if (sPointer >= s.length()) {
            while (pPointer + 1 < p.length() && p.charAt(pPointer + 1) == '*') {
                pPointer += 2;
            }
            return pPointer >= p.length();
        }
        if (pPointer >= p.length()) {
            return false;
        }
        if (cache[sPointer][pPointer] == -1) {
            boolean hasMatch = false;
            if (pPointer + 1 < p.length() && p.charAt(pPointer + 1) == '*') {
                // match 0 to n of chatAt pPointer
                for (int i = 0; i <= s.length() - sPointer; i++) {
                    if (p.charAt(pPointer) != '.' && i > 0 && sPointer + i <= s.length() && s.charAt(sPointer + i - 1)
                        != p.charAt(pPointer)) {
                        break;
                    }
                    if (recursive(s, p, cache, sPointer + i, pPointer + 2)) {
                        hasMatch = true;
                        break;
                    }
                }
            } else {
                if (p.charAt(pPointer) == '.' || p.charAt(pPointer) == s.charAt(sPointer)) {
                    if (recursive(s, p, cache, sPointer + 1, pPointer + 1)) {
                        hasMatch = true;
                    }
                }
            }
            cache[sPointer][pPointer] = hasMatch ? 1 : 0;
        }
        return cache[sPointer][pPointer] == 1;
    }
}