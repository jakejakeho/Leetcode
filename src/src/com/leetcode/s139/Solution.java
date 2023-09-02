package src.com.leetcode.s139;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(solution.wordBreak("cars", List.of("car", "ca", "rs")));
    }

    public static class Trie {
        Trie[] tries = new Trie[26];
        boolean isWordEnd = false;

        static Trie buildTrie(List<String> wordDict) {
            Trie trie = new Trie();
            for (String word : wordDict) {
                trie.insert(word);
            }
            return trie;
        }

        void insert(String s) {
            Trie pointer = this;
            for (char c : s.toCharArray()) {
                if (pointer.tries[c - 'a'] == null)
                    pointer.tries[c - 'a'] = new Trie();
                pointer = pointer.tries[c - 'a'];
            }
            pointer.isWordEnd = true;
        }

        boolean exist(String s, int start, int end) {
            Trie pointer = this;
            if (end >= s.length()) {
                return false;
            }
            for (int i = start; i <= end; i++) {
                pointer = pointer.tries[s.charAt(i) - 'a'];
                if (pointer == null) {
                    return false;
                }
            }
            return pointer.isWordEnd;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = Trie.buildTrie(wordDict);
        int minWordDictSize = Integer.MAX_VALUE;
        int maxWordDictSize = 0;
        for (String word : wordDict) {
            minWordDictSize = Math.min(word.length(), minWordDictSize);
            maxWordDictSize = Math.max(word.length(), maxWordDictSize);
        }

        Boolean[] cache = new Boolean[s.length()];
        return dfs(s, trie, minWordDictSize, maxWordDictSize, cache, 0);
    }

    public boolean dfs(String s, Trie trie, int minWordDictSize, int maxWordDictSize, Boolean[] cache, int i) {
        if (i >= s.length()) {
            return false;
        }
        if (cache[i] == null) {
            boolean exists = false;
            for (int j = minWordDictSize; j <= maxWordDictSize; j++) {
                boolean trieExists = trie.exist(s, i, i + j - 1);
                if (trieExists && (i + j - 1 == s.length() - 1 || dfs(s, trie, minWordDictSize, maxWordDictSize, cache, i + j))) {
                    exists = true;
                    break;
                }
            }
            cache[i] = exists;
        }
        return cache[i];
    }

}