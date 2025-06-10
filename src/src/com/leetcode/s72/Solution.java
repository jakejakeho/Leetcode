package src.com.leetcode.s72;
import java.util.Arrays;

class Solution {

    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return recursion(word1, word2, cache, 0, 0);
    }

    private Integer recursion(String word1, String word2, int[][] cache, int i, int j) {
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            return word1.length() - i;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int min = 1000000;
        if (word1.charAt(i) == word2.charAt(j)) {
            min = recursion(word1, word2, cache, i + 1, j + 1);
        } else {
            // delete
            min = Math.min(min, 1 + recursion(word1, word2, cache, i + 1, j));
            // insert
            min = Math.min(min, 1 + recursion(word1, word2, cache, i, j + 1));
            // replace
            min = Math.min(min, 1 + recursion(word1, word2, cache, i + 1, j + 1));
        }
        cache[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
    }
}