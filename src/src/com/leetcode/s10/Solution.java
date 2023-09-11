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
        //System.out.println(solution.isMatch("aa", "a"));
        //System.out.println("Expected = true result = " + solution.isMatch("aa", "a*"));
        //System.out.println(solution.isMatch("ab", ".*"));
        //System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
        //System.out.println(solution.isMatch("aaa", "a*a"));
        //System.out.println(solution.isMatch("aaa", "ab*a*c*a"));
        //System.out.println(solution.isMatch("aab", "c*a*b"));
        //System.out.println("Expected = false result = " + solution.isMatch("ssippi", "s*p*."));
        //System.out.println("Expected = true result = " + solution.isMatch("aab", "c*a*b"));
        //System.out.println("Expected = true result = " + solution.isMatch("a", "ab*"));
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
                    //System.out.println(
                    //    "" + i + s.charAt(sPointer) + " has* sPointer = " + sPointer + " pPointer" + " = " + pPointer
                    //        + " pChar = " + p.charAt(pPointer));
                    if (p.charAt(pPointer) != '.' && i > 0 && sPointer + i <= s.length() && s.charAt(sPointer + i - 1)
                        != p.charAt(pPointer)) {
                        break;
                    }
                    //System.out.println(
                    //    "" + i + s.charAt(sPointer) + "recursive i = " + i + " sChar= " + (sPointer + i >= s.length()
                    //        ? "null" : s.charAt(sPointer + i)) + " pChar = " + p.charAt(pPointer));
                    if (recursive(s, p, cache, sPointer + i, pPointer + 2)) {
                        //System.out.println(
                        //    "" + i + s.charAt(sPointer) + "has* matched!! s = " + s.charAt(sPointer) + " p = "
                        //        + p.charAt(pPointer) + " i = " + i);
                        hasMatch = true;
                        break;
                    }
                }
            } else {
                if (p.charAt(pPointer) == '.' || p.charAt(pPointer) == s.charAt(sPointer)) {
                    //System.out.println("no* match sPointer = " + sPointer + " pPointer = " + pPointer);
                    if (recursive(s, p, cache, sPointer + 1, pPointer + 1)) {
                        //System.out.println("no* matched!! s = " + s.charAt(sPointer) + " p = " + p.charAt(pPointer));
                        hasMatch = true;
                    }
                }
            }
            cache[sPointer][pPointer] = hasMatch ? 1 : 0;
        }
        return cache[sPointer][pPointer] == 1;
    }
}