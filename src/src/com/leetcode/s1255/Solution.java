package src.com.leetcode.s1255;

import java.util.Arrays;

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        boolean[] used = new boolean[letters.length];
        int maxScore = backTracking(words, letters, score, used, 0);
        return maxScore;
    }

    private int backTracking(String[] words, char[] letters, int[] score, boolean[] used, int i) {
        if (i == words.length) {
            return 0;
        }
        int currentScore = 0;
        // include this index
        String word = words[i];
        char[] wordArr = word.toCharArray();
        int[] thisUsed = new int[word.length()];
        Arrays.fill(thisUsed, -1);
        boolean found = false;
        int charIndex = 0;
        int includeScore = 0;
        for (char c : wordArr) {
            found = false;
            for (int j = 0; j < letters.length; j++) {
                if (!used[j] && letters[j] == c) {
                    thisUsed[charIndex++] = j;
                    used[j] = true;
                    found = true;
                    includeScore += score[c - 'a'];
                    break;
                }
            }
            if (!found)
                break;
        }
        if (found) {
            currentScore = includeScore + backTracking(words, letters, score, used, i + 1);
        }

        for (int k : thisUsed) {
            if (k != -1)
                used[k] = false;
        }
        // not include this index
        currentScore = Math.max(currentScore, backTracking(words, letters, score, used, i + 1));

        return currentScore;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScoreWords(new String[]{"dog", "cat", "dad", "good"}, new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(solution.maxScoreWords(new String[]{"xxxz", "ax", "bx", "cx"}, new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'}, new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}));
        System.out.println(solution.maxScoreWords(new String[]{"leetcode"}, new char[]{'l', 'e', 't', 'c', 'o', 'd'}, new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}));
    }
}