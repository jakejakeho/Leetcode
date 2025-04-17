package src.com.leetcode.s2559;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final Set<Character> VOWEL_SET = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public int[] vowelStrings(String[] words, int[][] queries) {
        int upperRange = 0;
        int lowerRange = words.length - 1;
        for (int[] query : queries) {
            upperRange = Math.max(upperRange, query[1]);
            lowerRange = Math.min(lowerRange, query[0]);
        }

        boolean[] isVowel = new boolean[words.length];
        for (int i = lowerRange; i <= upperRange; i++) {
            String word = words[i];
            if (VOWEL_SET.contains(word.charAt(0)) && VOWEL_SET.contains(word.charAt(word.length() - 1))) {
                isVowel[i] = true;
            }
        }

        int[] isVowelTotal = new int[words.length + 1];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isVowel[i])
                count++;
            isVowelTotal[i + 1] = count;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int lower = queries[i][0];
            int upper = queries[i][1];
            result[i] = isVowelTotal[upper + 1] - isVowelTotal[lower];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.vowelStrings(new String[] {"aba", "bcb", "ece", "aa", "e"},
            new int[][] {{0, 2}, {1, 4}, {1, 1}})));
        System.out.println(
            Arrays.toString(solution.vowelStrings(new String[] {"a", "e", "i"}, new int[][] {{0, 2}, {0, 1}, {2, 2}})));
    }
}