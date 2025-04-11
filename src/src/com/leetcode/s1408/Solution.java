package src.com.leetcode.s1408;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    private static class Trie {
        Map<Character, Trie> m = new HashMap<>();
        boolean isWordEnd = false;
    }

    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        Map<Character, Trie> trie = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            result.addAll(sub(trie, word, set));
            addWordToTrie(trie, word);
        }
        return new ArrayList<>(result);
    }

    private List<String> sub(Map<Character, Trie> trie, String word, Set<String> set) {
        List<String> match = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder substring = new StringBuilder();
            Map<Character, Trie> triePointer = trie;
            for (int j = i; j < word.length(); j++) {
                Character c = word.charAt(j);
                if (triePointer.containsKey(c)) {
                    substring.append(c);
                    if (triePointer.get(c).isWordEnd && set.contains(substring.toString())) {
                        match.add(substring.toString());
                    }
                    triePointer = triePointer.get(c).m;
                } else {
                    break;
                }
            }
        }
        return match;
    }

    private void addWordToTrie(Map<Character, Trie> trie, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!trie.containsKey(c)) {
                trie.put(c, new Trie());
            }
            if (i == word.length() -1) {
                trie.get(c).isWordEnd = true;
            }
            trie = trie.get(c).m;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * Given an array of string words, return all strings in words that are a substring of another word. You can return the answer in any order.
         *
         *
         *
         * Example 1:
         *
         * Input: words = ["mass","as","hero","superhero"]
         * Output: ["as","hero"]
         * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
         * ["hero","as"] is also a valid answer.
         * Example 2:
         *
         * Input: words = ["leetcode","et","code"]
         * Output: ["et","code"]
         * Explanation: "et", "code" are substring of "leetcode".
         * Example 3:
         *
         * Input: words = ["blue","green","bu"]
         * Output: []
         * Explanation: No string of words is substring of another string.
         */


        //System.out.println(solution.stringMatching(new String[]{"mass","as","hero","superhero"}));
        System.out.println(solution.stringMatching(new String[]{"leetcode","et","code"}));
        //System.out.println(solution.stringMatching(new String[]{"blue","green","bu"}));
    }
}