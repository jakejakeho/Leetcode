package src.com.leetcode.s208;

import java.util.HashMap;

class Trie {
    Trie[] trieHashMap;
    boolean isWordEnd;

    public Trie() {
        trieHashMap = new Trie[26];
        isWordEnd = false;
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Trie current = this;
        for (char c : chars) {
            if (current.trieHashMap[c - 'a'] == null) {
                current.trieHashMap[c - 'a'] = new Trie();
            }
            current = current.trieHashMap[c - 'a'];
        }
        current.isWordEnd = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Trie current = this;
        for (char c : chars) {
            if (current.trieHashMap[c - 'a'] != null) {
                current = current.trieHashMap[c - 'a'];
            } else {
                return false;
            }
        }
        return current.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Trie current = this;
        for (char c : chars) {
            if (current.trieHashMap[c - 'a'] != null) {
                current = current.trieHashMap[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}
