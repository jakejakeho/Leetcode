package src.com.leetcode.s2486;

class Solution {
    public int appendCharacters(String s, String t) {
        int tIndex = 0;
        for (int i = 0; tIndex < t.length() && i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(tIndex)) {
                tIndex++;
            }
        }
        return t.length() - tIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.appendCharacters("coaching", "coding"));
        System.out.println(solution.appendCharacters("abcde", "a"));
        System.out.println(solution.appendCharacters("z", "abcde"));
    }
}