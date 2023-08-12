package src.com.leetcode.s212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    private static int COLS;
    private static int ROWS;

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;

        HashSet<String> res = new HashSet<>();
        HashSet<String> visit = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(r, c, root, "", res, visit, board, root);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(int r, int c, Trie node, String word, HashSet<String> res, HashSet<String> visit, char[][] board, Trie root) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS || !node.hashMap.containsKey(board[r][c]) || node.hashMap.get(board[r][c]).refs < 1 || visit.contains(r + "-" + c)) {
            return;
        }

        visit.add(r + "-" + c);
        node = node.hashMap.get(board[r][c]);
        word += board[r][c];
        if (node.isWord) {
            node.isWord = false;
            res.add(word);
            root.removeWord(word);
        }

        dfs(r + 1, c, node, word, res, visit, board, root);
        dfs(r - 1, c, node, word, res, visit, board, root);
        dfs(r, c + 1, node, word, res, visit, board, root);
        dfs(r, c - 1, node, word, res, visit, board, root);
        visit.remove(r + "-" + c);
    }

    private class Trie {
        HashMap<Character, Trie> hashMap;
        boolean isWord;

        int refs;

        public Trie() {
            hashMap = new HashMap<>();
            isWord = false;
            refs = 0;
        }

        public void addWord(String word) {
            Trie current = this;
            current.refs++;
            for (Character c : word.toCharArray()) {
                current.hashMap.putIfAbsent(c, new Trie());
                current = current.hashMap.get(c);
                current.refs++;
            }
            current.isWord = true;
        }

        public void removeWord(String word) {
            Trie current = this;
            current.refs--;
            for (Character c : word.toCharArray()) {
                if (current.hashMap.containsKey(c)) {
                    current = current.hashMap.get(c);
                    current.refs--;
                }
            }
        }
    }
}