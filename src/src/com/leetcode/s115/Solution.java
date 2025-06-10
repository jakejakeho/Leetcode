package src.com.leetcode.s115;

class Solution {
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i][t.length()] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    cache[i][j] = cache[i][j] + cache[i + 1][j + 1];
                }
                cache[i][j] = cache[i][j] + cache[i + 1][j];
            }

        }
        return cache[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
        System.out.println(solution.numDistinct("babgbag", "bag"));
    }
}