package src.com.leetcode.s140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    class TrieNode {
        char c;
        boolean isWord;
        Map<Character, TrieNode> map = new HashMap<>();

        public TrieNode(char c, boolean isWord) {
            this.c = c;
            this.isWord = isWord;
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Character, TrieNode> map = getTrieNodeMap(wordDict);
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, map, result, sb);
        return result;
    }

    private void dfs(String s, int i, Map<Character, TrieNode> map, List<String> result, StringBuilder sb) {
        if (i == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        int index = i;
        Map<Character, TrieNode> pointerMap = map;
        while (index < s.length() && pointerMap.containsKey(s.charAt(index))) {
            char c = s.charAt(index);
            sb.append(c);
            TrieNode trieNode = pointerMap.get(c);
            pointerMap = trieNode.map;
            if (trieNode.isWord) {
                sb.append(' ');
                dfs(s, index + 1, map, result, new StringBuilder(sb));
                sb.deleteCharAt(sb.length() - 1);
            }
            index++;
        }
    }

    public Map<Character, TrieNode> getTrieNodeMap(List<String> wordDict) {
        Map<Character, TrieNode> map = new HashMap<>();
        for (String word : wordDict) {
            map.computeIfAbsent(word.charAt(0), (k) -> new TrieNode(k, false));
            TrieNode root = null;
            for (char c : word.toCharArray()) {
                if (root == null) {
                    root = map.get(word.charAt(0));
                } else {
                    root.map.computeIfAbsent(c, (k) -> new TrieNode(k, false));
                    root = root.map.get(c);
                }
            }
            root.isWord = true;
        }
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
        System.out.println(solution.wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}