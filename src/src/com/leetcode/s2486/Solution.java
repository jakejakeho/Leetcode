package src.com.leetcode.s2486;

class Solution {
    public int appendCharacters(String s, String t) {
        int tPointer = 0;
        for (int sPointer = 0; sPointer < s.length(); sPointer++) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                tPointer++;
            }
            if (tPointer >= t.length()) {
                break;
            }
        }
        return t.length() - tPointer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.appendCharacters("coaching", "coding"));
        System.out.println(solution.appendCharacters("abcde", "a"));
        System.out.println(solution.appendCharacters("z", "abcde"));
    }
}