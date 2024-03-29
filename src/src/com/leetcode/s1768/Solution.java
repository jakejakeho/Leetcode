package src.com.leetcode.s1768;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1 = 0;
        int w2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (w1 < word1.length() || w2 < word2.length()) {
            if (w1 < word1.length()) {
                stringBuilder.append(word1.charAt(w1++));
            }
            if (w2 < word2.length()) {
                stringBuilder.append(word2.charAt(w2++));
            }
        }
        return stringBuilder.toString();
    }
}